package my.zjm.spring.boot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangmingzhou
 */
@Controller @SpringBootApplication public class HelloWorld {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    /**
     * 处理请求URL：/hello。
     *
     * @param request
     * @param response
     * @param modelMap 用于填充thymeleaf前端模板
     * @return 返回视图名称(hello.html)。
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET) public String hello(HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap) {
        LOG.info("Hello world!");

        List<String> list = new ArrayList<>();
        list.add("hello 001");
        list.add("hello 002");
        list.add("hello 003");
        modelMap.put("list", list);

        return "hello";
    }

    /**
     * 处理请求URL：/sayHello。
     *
     * @return 显示内容（添加@ResponseBody注解）。
     */
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET) @ResponseBody public String sayHello() {
        LOG.info("Hello world!");
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorld.class, args);
    }
}
