package com.expeditors.ems.endpoint;

import com.expeditors.ems.dto.response.BaseResponse;
import com.expeditors.ems.dto.response.BaseResponseWoData;
import com.expeditors.ems.dto.response.LoginResponse;
import com.expeditors.ems.dto.response.UserResponse;
import com.expeditors.ems.dto.resquest.*;
import com.expeditors.ems.entity.Task;

import com.expeditors.ems.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.graphql.data.method.annotation.QueryMapping;


import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;



    @PostMapping("/user")
    public BaseResponseWoData createUser(@RequestBody UserCreateRequest userCreateRequest , HttpServletRequest request) {

          //  userService.validateUser(Integer.parseInt(request.getHeader("x-UserId")),"Admin");

            userService.userMethod(userCreateRequest);


            return new BaseResponseWoData("Pass", "User created successfully");

    }
    @PutMapping("/password/{id}")
    public BaseResponseWoData updatePassword(@PathVariable Integer id, @RequestBody PasswordUpdate passwordUpdate, HttpServletRequest request){
        //userService.ValidateUser(Integer.parseInt(request.getHeader("X-UserId")),"Admin");
        userService.updatePassword(passwordUpdate,id);
        return new BaseResponseWoData("Pass", "User updated  successfully");
    }
     @CrossOrigin(origins = "http://localhost:8080/login")
    @PostMapping( "/login")
    public LoginResponse loginEmployee(@RequestBody LoginRequest loginRequest)
    {
        LoginResponse loginResponse = userService.loginRes(loginRequest);
        return loginResponse;
    }

@CrossOrigin(origins = "http://localhost:8080/user")
    @GetMapping("/user")
    public BaseResponse getUsers(HttpServletRequest request) {
//        userService.validateUser(Integer.parseInt(request.getHeader("x-UserId")),"Admin");

        return new BaseResponse("Mission completed", "YOUR DID A GREAT JOB", userService.getUsers());
    }

    @PutMapping("/update")
    public BaseResponseWoData getUpdate( @RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request){
      //  userService.ValidateUser(Integer.parseInt(request.getHeader("X-UserId")),"Admin");
        userService.updateUser(userUpdateRequest);
        return new BaseResponseWoData("Pass", "User updated  successfully");
    }

    @PostMapping("/task")
    public BaseResponseWoData createUser(@RequestBody Tasks tasks , HttpServletRequest request) {

//        userService.validateUser(Integer.parseInt(request.getHeader("x-UserId")),"Admin");

        userService.createTasks(tasks);


        return new BaseResponseWoData("Pass", "Task created successfully");

    }

    @GetMapping("/task")
    public BaseResponse getTask(HttpServletRequest request) {
      //  userService.validateUser(Integer.parseInt(request.getHeader("x-UserId")),"Admin");

        return new BaseResponse("Mission completed", "YOUR DID A GREAT JOB", userService.getTask());
    }

    @PutMapping("/task/{id}")
    public BaseResponseWoData updateTaskStatus(@PathVariable Integer id, @RequestBody UpdateTaskRequest updateTaskRequest, HttpServletRequest request){
       // userService.ValidateUser(Integer.parseInt(request.getHeader("X-UserId")),"Admin");
        userService.updateTask(updateTaskRequest);
        return new BaseResponseWoData("Pass", "User updated  successfully");
    }
    @GetMapping("/getTask/{id}")
    public BaseResponse taskResponse(@PathVariable Integer id ){
       // userService.validateUser(Integer.parseInt(request.getHeader("Dev")),"Developer");


        return new BaseResponse("developer's tasks","the tasks are",userService.getDevTask(id));
    }


    @PostMapping("/taskAllocation")
    public BaseResponseWoData allocateTask(@RequestBody TaskAllocationRequest taskAllocationRequest , HttpServletRequest request){
      //  userService.validateUser(Integer.parseInt(request.getHeader("x-UserId")),"Admin");
        userService.AllocateTask(taskAllocationRequest);

        return new BaseResponseWoData("pass","Task allocated successfully");
    }

    @CrossOrigin(origins = "http://localhost:8080/taskAllocation")
    @GetMapping("/taskAllocation")
    public BaseResponse getTaskAllocation(HttpServletRequest request) {
      //  userService.validateUser(Integer.parseInt(request.getHeader("X")),"Admin");

        return new BaseResponse("Mission completed", "YOUR ID A GREAT JOB", userService.getTaskAllocation());

    }

    @PostMapping("/candidate")
    public BaseResponseWoData candidate(@RequestBody CandidateRequest candidateRequest){
        userService.candidate(candidateRequest);

        return new BaseResponseWoData("pass","candidate allocated successfully");

    }
    @GetMapping("/candidate")
    public BaseResponse getCandidate(HttpServletRequest request) {
    //    userService.validateUser(Integer.parseInt(request.getHeader("x-UseRId")),"Admin");

        return new BaseResponse("Mission completed", "YOUR DID A GREAT JOB", userService.candidateResponses());

    }

    @PostMapping("/expense")
    public BaseResponseWoData expense(@RequestBody ExpenseDetailRequest expenseDetailRequest,HttpServletRequest request){
    //    userService.validateUser(Integer.parseInt(request.getHeader("Expense")),"Accountant");
        userService.expense(expenseDetailRequest);

        return new BaseResponseWoData("pass","expense created successfully");
    }
    @GetMapping("/expense")
    public BaseResponse getExpense(HttpServletRequest request) {
     //        userService.validateUser(Integer.parseInt(request.getHeader("expense")),"Admin");

        return new BaseResponse("Mission completed", "YOUR DID A GREAT JOB", userService.expenseResponses());

    }




}
