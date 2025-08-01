package com.expeditors.ems.service;


import com.expeditors.ems.dto.response.*;
import com.expeditors.ems.dto.resquest.*;
import com.expeditors.ems.entity.*;
import com.expeditors.ems.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskAllocationRepository taskAllocationRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void userMethod(UserCreateRequest userCreateRequest) {
        UserDetails userDetails = new UserDetails();
        userDetails.setName(userCreateRequest.getName());
        userDetails.setEmail(userCreateRequest.getEmail());
        userDetails.setCreateDate(LocalDateTime.now());
        userDetails.setPassword(userCreateRequest.getPassword());
        Role role = new Role();
        role.setId(userCreateRequest.getRole_id());
        userDetails.setRole(role);
        userRepository.save(userDetails);

    }

    public List<UserResponse> getUsers() {
        List<UserDetails> userD = this.userRepository.findAll();
        List<UserResponse> userR = new ArrayList<>();

        userD.forEach(user -> {
            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setName(user.getName());
            userResponse.setEmail(user.getEmail());
            userResponse.setRole(user.getRole().getName());
            userR.add(userResponse);
        });
        return userR;

    }


    public void validateUser(Integer requestingUserId, String resource) {
        UserDetails userDetails = this.userRepository.findById(requestingUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!userDetails.getRole().getName().equalsIgnoreCase(resource)) {
            throw new RuntimeException("Unauthorised user");
        }
    }

    public void ValidateUser(Integer requestingUserId, String resource) {
        UserDetails userDetails = userRepository.findById(requestingUserId).orElseThrow(() -> new RuntimeException("User not found"));
        if(!userDetails.getRole().getName().equalsIgnoreCase(resource)) {
            throw new RuntimeException("Unauthorized user");
        }
    }

    public void updateUser(UserUpdateRequest userUpdateRequest) {
        UserDetails userDetails = this.userRepository.findById(userUpdateRequest.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        userDetails.setName(userUpdateRequest.getName());
        userDetails.setEmail(userUpdateRequest.getEmail());
        userRepository.save(userDetails);
    }

        public void createTasks(Tasks tasks){
        Task task = new Task();

        task.setId(tasks.getId());
        task.setName(tasks.getName());
        task.setDescription(tasks.getDescription());
        task.setCreatedAt(LocalDateTime.now());
        UserDetails userDetails = new UserDetails();
        userDetails.setId(tasks.getCreatedBy());
        task.setUserDetails(userDetails);
        taskRepository.save(task);

    }
    public List<TaskResponse> getTask(){
        List<Task> task =this.taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();

        task.forEach(tasks->{
            TaskResponse taskResponse = new TaskResponse();

            taskResponse.setId(tasks.getId());
            taskResponse.setName(tasks.getName());
            taskResponse.setDescription(tasks.getDescription());
            taskResponse.setCreatedAt(tasks.getCreatedAt());
            taskResponse.setCreatedBy(tasks.getUserDetails().getId());

            taskResponses.add(taskResponse);
        });
        return taskResponses;
    }
    public void updateTask(UpdateTaskRequest updateTaskRequest){
        TaskAllocation taskAllocation= this.taskAllocationRepository.findById(updateTaskRequest.getId()).orElseThrow(()-> new RuntimeException("User Not Found"));

        taskAllocation.setId(updateTaskRequest.getId());
        taskAllocation.setStatus(updateTaskRequest.getStatus());

        taskAllocationRepository.save(taskAllocation);

    }


    public List<TasksResponse> getDevTask(Integer id) {
        List<TaskAllocation> taskAllocationEntities = this.taskAllocationRepository.findByDevIdId(id);
        List<TasksResponse> taskResponseList = new ArrayList<>();
        taskAllocationEntities.forEach(taskAllocationEntity -> {
            TasksResponse taskResponse = new TasksResponse();
            taskResponse.setId(taskAllocationEntity.getId());
            taskResponse.setManagerName(taskAllocationEntity.getUserDetails1().getName());
            taskResponse.setTaskName(taskAllocationEntity.getTask().getName());
            taskResponse.setTaskStatus(taskAllocationEntity.getStatus());
            taskResponse.setDevname(taskAllocationEntity.getDevId().getName());
            taskResponse.setCreatedAt(taskAllocationEntity.getAssignedDate());
            taskResponseList.add(taskResponse);
        });
        return taskResponseList;
    }

    public void AllocateTask(TaskAllocationRequest taskAllocationRequest ){
        TaskAllocation taskAllocation = new TaskAllocation();
        Task taskEntity = new Task();
        UserDetails userDetails = new UserDetails();
        UserDetails userDetails1 = new UserDetails();

        taskEntity.setId(taskAllocationRequest.getTask_id());
        userDetails1.setId(taskAllocationRequest.getAssignedby());
        userDetails.setId(taskAllocationRequest.getDeveloperid());
        taskAllocation.setAssignedDate(LocalDateTime.now());
        taskAllocation.setStatus(taskAllocationRequest.getStatus());
        taskAllocation.setTask(taskEntity);
        taskAllocation.setUserDetails1(userDetails1);
        taskAllocation.setDevId(userDetails);
        taskAllocationRepository.save(taskAllocation);

    }

    public List<TaskAllocationResponse>getTaskAllocation(){
        List<TaskAllocation> taskAllocations = this.taskAllocationRepository.findAll();
        List<TaskAllocationResponse> taskAllocationResponses = new ArrayList<>();

        taskAllocations.forEach(taskAllocation -> {
            TaskAllocationResponse taskAllocationResponse = new TaskAllocationResponse();

                    taskAllocationResponse.setId(taskAllocation.getId());
                    taskAllocationResponse.setTask_id(taskAllocation.getTask().getId());
                    taskAllocationResponse.setAssignedby(taskAllocation.getUserDetails1().getId());
                    taskAllocationResponse.setAssignedDate(taskAllocation.getAssignedDate());
                    taskAllocationResponse.setStatus(taskAllocation.getStatus());
                    taskAllocationResponse.setDeveloperid(taskAllocation.getDevId().getId());

                    taskAllocationResponses.add(taskAllocationResponse);

                }
                );
        return taskAllocationResponses;

    }

    public void candidate(CandidateRequest candidateRequest){

        CandidateEntity candidateEntity = new CandidateEntity();
        HIringStatusEntity hiringStatusEntity = new HIringStatusEntity();
        Role role = new Role();



        candidateEntity.setId(candidateRequest.getId());
        candidateEntity.setName(candidateRequest.getName());
        candidateEntity.setEmail(candidateRequest.getEmail());
        candidateEntity.setScheduledAt(candidateRequest.getScheduledAt());
        candidateEntity.setInterviewerId(candidateRequest.getInterviewerId());
        role.setId(candidateEntity.getId());
        candidateEntity.setRole(role);

        hiringStatusEntity.setId(candidateRequest.getId());

        candidateEntity.setHIringStatusEntity(hiringStatusEntity);

        int status = candidateEntity.getHIringStatusEntity().getId();
        if (status ==5){
            UserDetails userDetails = new UserDetails();
            Role role1 = new Role();

            userDetails.setName(candidateEntity.getName());
            userDetails.setEmail(candidateEntity.getEmail());
            role1.setId(candidateRequest.getRoleId());
            userDetails.setRole(role1);
            userDetails.setCreateDate(candidateEntity.getScheduledAt());
            userDetails.setPassword("@Welcome1");

            userRepository.save(userDetails);

        }
        candidateRepository.save(candidateEntity);
    }
    public List<CandidateResponse> candidateResponses(){
        List<CandidateEntity> candidateEntities = this.candidateRepository.findAll();
        List<CandidateResponse> candidateResponses = new ArrayList<>();

        candidateEntities.forEach(candidateEntity -> {
            CandidateResponse candidateResponse = new CandidateResponse();

            candidateResponse.setId(candidateEntity.getId());
            candidateResponse.setName(candidateEntity.getName());
            candidateResponse.setEmail(candidateEntity.getEmail());
            candidateResponse.setStatusId(candidateEntity.getHIringStatusEntity().getId());;
            candidateResponse.setInterviewerId(candidateEntity.getInterviewerId());
            candidateResponse.setScheduledAt(candidateEntity.getScheduledAt());
            candidateResponse.setRoleId(candidateEntity.getRole().getId());

            candidateResponses.add(candidateResponse);
        });
        return candidateResponses;
    }
    public void expense(ExpenseDetailRequest expenseDetailRequest){
        ExpenseDetailEntity expenseDetailEntity = new ExpenseDetailEntity();
        UserDetails userDetails = new UserDetails();
        EmployeeStatusEntity employeeStatusEntity = new EmployeeStatusEntity();
        ExpenseTypeEntity expenseTypeEntity = new ExpenseTypeEntity();
        UserDetails userDetails1 = new UserDetails();

        userDetails.setId(expenseDetailRequest.getUserId());
        userDetails1.setId(expenseDetailRequest.getAccountedBy());
        expenseDetailEntity.setId(expenseDetailRequest.getTypeId());
        employeeStatusEntity.setId(expenseDetailRequest.getStatusId());

        expenseDetailEntity.setId(expenseDetailRequest.getId());
        expenseDetailEntity.setSpentAt(expenseDetailRequest.getSpentAt());
        expenseDetailEntity.setDescription(expenseDetailRequest.getDescription());
        expenseDetailEntity.setAmount(expenseDetailRequest.getAmount());
        expenseDetailEntity.setCreateAt(expenseDetailRequest.getCreateAt());
        expenseDetailEntity.setAccountedAt(expenseDetailRequest.getAccountedAt());
        expenseDetailEntity.setUserDetails(userDetails);
        expenseDetailEntity.setUserDetails1(userDetails1);
        expenseDetailEntity.setExpenseDetailEntity(expenseDetailEntity);
        expenseDetailEntity.setEmployeeStatusEntity(employeeStatusEntity);

        expenseRepository.save(expenseDetailEntity);
    }
    public List<ExpenseResponse> expenseResponses(){
        List<ExpenseDetailEntity> expenseDetailEntities =this.expenseRepository.findAll();
        List<ExpenseResponse> expenseResponses = new ArrayList<>();

        expenseDetailEntities.forEach(expenseDetailEntity -> {
            ExpenseResponse response = new ExpenseResponse();


            response.setId(expenseDetailEntity.getId());
            response.setUserId(expenseDetailEntity.getUserDetails().getId());
            response.setTypeId(expenseDetailEntity.getExpenseDetailEntity().getId());
            response.setStatusId(expenseDetailEntity.getEmployeeStatusEntity().getId());
            response.setSpentAt(expenseDetailEntity.getSpentAt());
            response.setAmount(expenseDetailEntity.getAmount());
            response.setDescription(expenseDetailEntity.getDescription());
            response.setAccountedAt(expenseDetailEntity.getAccountedAt());
            response.setAccountedBy(expenseDetailEntity.getUserDetails1().getId());
            response.setCreateAt(expenseDetailEntity.getCreateAt());

            expenseResponses.add(response);
        });
        return expenseResponses;
    }

    public void updatePassword(PasswordUpdate passwordUpdate,int id){
        UserDetails userDetails = this.userRepository.findById(id).orElseThrow(()->new RuntimeException("Candidate not found"));

        userDetails.setPassword(passwordUpdate.getPassword());
        userRepository.save(userDetails);
    }
    public LoginResponse loginRes(LoginRequest loginRequest){
        UserDetails userDetails = userRepository.findByEmail(loginRequest.getUsername());
        System.out.println(userDetails);
        if(userDetails !=null) {
            String password = loginRequest.getPassword();
            String encodePassword = passwordEncoder.encode(userDetails.getPassword());
            //System.out.println(encodePassword);
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight) {
                List<UserDetails> userDetails1 = userRepository.findOneByEmailAndPassword(loginRequest.getUsername(), password);
                if (!userDetails1.isEmpty()) {
                    return new LoginResponse(loginRequest.getUsername(), "abc",true,"Login Success",userDetails.getRole().getName());
                } else {
                    return new LoginResponse(loginRequest.getUsername(),"",  false,"fail","");
                }
            } else {
                return new LoginResponse(loginRequest.getUsername(),"",false,"password not match","");
            }
        }else{
            return new LoginResponse("","",false,"email not exists","");
        }
    }


}