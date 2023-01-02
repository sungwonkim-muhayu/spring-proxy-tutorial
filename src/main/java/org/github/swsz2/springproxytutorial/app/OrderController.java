package org.github.swsz2.springproxytutorial.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("v1")
@ResponseBody
// @RestController // spring boot 3.0부턴 인터페이스에 @RequestMapping을 붙여도 탐색하지 않아 컨트롤러도 붙어야 함
public interface OrderController {

  @GetMapping("request")
  String request(@RequestParam("itemId") final String itemId);

  @GetMapping("no-log")
  String noLog();
}
