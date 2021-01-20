package com.starts.turingclient.feignservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "BOOK-SERVICE", configuration = FeignConfig.class, fallbackFactory = BookFallbackFactory.class)
public interface BookFeignService {

    @GetMapping("/book")
    String getBooksFromService(@RequestParam(value = "bookName") String bookName);
}

@Component
 class BookFallbackFactory implements FallbackFactory<FallbackWithFactory> {

    @Override
    public FallbackWithFactory create(Throwable cause) {
        return new FallbackWithFactory();
    }

}

class FallbackWithFactory implements BookFeignService {
    private static final Logger LOG = LoggerFactory.getLogger(BookFeignService.class);
    @Override
    public String getBooksFromService(String bookName) {
        //throw new NoFallbackAvailableException("Boom!", new HttpException());
        return "Fixed response";
    }

}
