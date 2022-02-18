package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 목록 조회: GET /users
     * 회원 등록: POST /users
     * 회원 조회: GET  /users/{userId}
     * 회원수정: PATCH /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     * @return
     */

    @GetMapping
    public String user(){
        return "get users";
    }

    @PostMapping
    public String addUser(){
        return "post users";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userid = "+ userId;
    }

    @PatchMapping ("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userid = "+ userId;
    }

    @DeleteMapping ("/mapping/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userid = "+ userId;
    }
}
