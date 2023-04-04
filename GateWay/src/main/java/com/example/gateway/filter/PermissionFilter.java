package com.example.gateway.filter;

import com.example.gateway.utils.JwtUtil;
import com.example.gateway.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class PermissionFilter implements GatewayFilter, Ordered {
    @Override
    public int getOrder() {
        return 0;
    }

    private RedisCache redisCache=new RedisCache();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //如果是第一次登录，则放行，下游的服务负责处理登录请求，并返回jwt。
        if(exchange.getRequest().getPath().value().equals("/user/login")){
            return chain.filter(exchange);
        }
        //如果附带了token，则检查token是否合法
        String token=exchange.getRequest().getHeaders().getFirst("token");
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //从redis中获取用户信息，查看用户是否登录
        String redisKey = "login" + userid;
        Object loginUser = redisCache.getCacheObject(redisKey);
        if(Objects.isNull(loginUser)){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}
