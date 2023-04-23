package academy.prog.javaprobot;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final int PAGE_SIZE = 5;
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{chatId}")
    @ResponseBody
public List<User> users(@PathVariable String chatId, @RequestParam(required = false, defaultValue = "0") int page){
    return userService.getUsers(PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id"));
}
//@GetMapping("/{chatId}/users")
//@ResponseBody
//public String users(@PathVariable String id){
//    return "users";
//}
    @RequestMapping("/users")
    public ModelAndView usersView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
