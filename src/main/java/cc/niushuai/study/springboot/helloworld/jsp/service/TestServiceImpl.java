package cc.niushuai.study.springboot.helloworld.jsp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService{

    @Override
    @Async
    public String testAsync() {
        log.info("2");

        log.info("3");
        return "testAsync";
    }
}
