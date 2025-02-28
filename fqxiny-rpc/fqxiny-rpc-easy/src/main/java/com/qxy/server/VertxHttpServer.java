package com.qxy.server;
import cn.hutool.http.server.HttpServerRequest;
import io.vertx.core.Vertx;
import io.vertx.core.spi.observability.HttpRequest;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:25
 */
public class VertxHttpServer implements HttpServer {
    @Override
    public void doStart(int port) {
        //init Vert.x
        Vertx vertx = Vertx.vertx();

        //init HttpServer
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        //监听端口并处理请求
        server.requestHandler(new HttpServerHandler());

        /*
        server.requestHandler(request -> {
            System.out.println("Received request: " + request.method() + " " + request.path());
            request.response().putHeader("content-type", "text/plain").end("Hello From Vert.x HTTP Server!");
        });
        */

        server.listen(port,result->{
            if(result.succeeded()){
                System.out.println("Server is now listening on port: " + port);
            }else{
                System.out.println("Failed to start server:" + result.cause());
            }
        });

    }
}


