package com.estudo.estudospring;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class ExampleController {

    @PostMapping("/response")
    @ResponseBody
    public Client postResponseController(@RequestBody Client client) {
        return new Client("Maria", "maria@gmail.com", "99999");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Client postResponseXmlContent(@RequestBody Client client) {
        return new Client("Maria", "maria@gmail.com", "99999");
    }
}
