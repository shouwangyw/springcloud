//package com.yw.springcloud.example.component;
//
//import com.google.common.util.concurrent.RateLimiter;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author yangwei
// * @date 2021-06-14 00:06
// */
//@Slf4j
//@Component
//public class RouteFilter extends ZuulFilter {
//    /**
//     * 创建一个令牌桶，每秒产生2个令牌
//     */
//    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);
//
//    @Override
//    public String filterType() {
//        // 指定路由之前执行过滤
//        return FilterConstants.PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        // 在系统最小值-3的前面执行
//        return -5;
//    }
//
////    @Override
////    public boolean shouldFilter() {
////        RequestContext context = RequestContext.getCurrentContext();
////        HttpServletRequest request = context.getRequest();
////        String user = request.getParameter("user");
////        String uri = request.getRequestURI();
////        // 只有当请求访问的是 /depart 且 user 为空时是不能通过过滤的
////        if (uri.contains("/depart") && StringUtils.isEmpty(user)) {
////            context.setSendZuulResponse(false);
////            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
////            return false;
////        }
////        return true;
////    }
//
//
//    @Override
//    public boolean shouldFilter() {
//        RequestContext context = RequestContext.getCurrentContext();
//
////        // 1. 若可以立即获取到一个令牌，则返回true，否则返回false，不阻塞
////        RATE_LIMITER.tryAcquire();
////        // 2. 若可以在3秒内获取到5个令牌，则返回true，否则返回false，不阻塞
////        RATE_LIMITER.tryAcquire(5, 3, TimeUnit.SECONDS);
////        // 3. 获取1个令牌，若获取不到，则阻塞
////        RATE_LIMITER.acquire();
////        // 4. 获取5个令牌，若获取不到，则阻塞
////        RATE_LIMITER.acquire(5);
//        if (!RATE_LIMITER.tryAcquire()) {
//            log.warn("访问量超载");
//            // 指定当前请求未通过zuul过滤，默认值为true
//            context.setSendZuulResponse(false);
//            // 向客户端响应状态码429，请求数量过多
//            context.setResponseStatusCode(429);
//        }
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        // 对请求通过过滤之后的处理逻辑
//        log.info("通过过滤");
//        return null;
//    }
//}
