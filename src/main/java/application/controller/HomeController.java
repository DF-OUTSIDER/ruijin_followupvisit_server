package application.controller;

import application.common.ActionResult;
import application.common.ClientError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

//    @RequestMapping("/error")
//    public ActionResult error() {
//        return new ClientError(false, "发生错误");
//    }
}
