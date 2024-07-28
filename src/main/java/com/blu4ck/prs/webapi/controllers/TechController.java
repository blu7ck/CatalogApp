package com.blu4ck.prs.webapi.controllers;

import com.blu4ck.prs.dto.requests.CreateTechRequest;
import com.blu4ck.prs.dto.requests.UpdateTechRequest;
import com.blu4ck.prs.dto.responses.GetAllTechResponse;
import com.blu4ck.prs.dto.responses.GetByIdTechResponse;
import com.blu4ck.prs.service.abstracts.TechService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teches")
public class TechController {
    private TechService techService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTechResponse> getAll(){
        return techService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdTechResponse getById(@PathVariable Long id){
       return this.techService.getById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateTechRequest createTechRequest){
        this.techService.create(createTechRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody UpdateTechRequest updateTechRequest){
        this.techService.update(updateTechRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Long id){
        this.techService.delete(id);
    }
}
