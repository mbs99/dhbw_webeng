package de.dhbw.webeng.swapitravel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info(System.getProperty("user.name"));

        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        Collections.list(nets).stream().forEach(nif -> {
            Collections.list(nif.getInetAddresses()).stream().forEach(ip -> logger.info(nif.getDisplayName() + ":" + ip.toString()));
        });

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
}
