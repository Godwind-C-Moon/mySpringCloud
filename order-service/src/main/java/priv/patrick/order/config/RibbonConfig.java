package priv.patrick.order.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class RibbonConfig {
    @Bean
    public IRule itemServiceRibbonRule() {
        return new RandomRule();
    }

    class MyRibbonRule extends AbstractLoadBalancerRule {
        private int total = 0;
        private int currentIndex = 0;

        @Override
        public void initWithNiwsConfig(IClientConfig clientConfig) {

        }

        public Server choose(ILoadBalancer lb, Object key) {
            if (lb == null) {
                return null;
            }
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();

                int serverCount = allList.size();
                if (serverCount == 0) {
                    /*
                     * No servers. End regardless of pass, because subsequent passes
                     * only get more restrictive.
                     */
                    return null;
                }

                if (total < 2) {
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total = 0;
                    currentIndex++;
                    if (currentIndex >= upList.size()) {
                        currentIndex = 0;
                    }
                }

                if (server == null) {
                    /*
                     * The only time this should happen is if the server list were
                     * somehow trimmed. This is a transient condition. Retry after
                     * yielding.
                     */
                    Thread.yield();
                    continue;
                }

                if (server.isAlive()) {
                    return (server);
                }

                // Shouldn't actually happen.. but must be transient or a bug.
                server = null;
                Thread.yield();
            }

            return server;

        }

        @Override
        public Server choose(Object key) {
            return choose(getLoadBalancer(), key);
        }
    }

}
