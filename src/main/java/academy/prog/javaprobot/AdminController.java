package academy.prog.javaprobot;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/admin")
public class AdminController {
    private static final int PAGE_SIZE = 5;
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{chatId}/users")
public List<User> users(@PathVariable String chatId, @RequestParam(required = false, defaultValue = "0") int page){
    return userService.getUsers(PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id"));
}
}
