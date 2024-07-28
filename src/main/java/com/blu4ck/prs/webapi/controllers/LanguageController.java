package com.blu4ck.prs.webapi.controllers;

import com.blu4ck.prs.dto.requests.CreateLanguageRequest;
import com.blu4ck.prs.dto.requests.UpdateLanguageRequest;
import com.blu4ck.prs.dto.responses.GetAllLanguageResponse;
import com.blu4ck.prs.dto.responses.GetByIdLanguageResponse;
import com.blu4ck.prs.service.abstracts.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/languages")
public class LanguageController {
private LanguageService languageService;

@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<GetAllLanguageResponse> getAll(){
  return languageService.getAll();
}
@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public GetByIdLanguageResponse getById(@PathVariable Long id){
    return  languageService.getById(id);
}
@PutMapping("/update")
@ResponseStatus(HttpStatus.CREATED)
public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest){
    this.languageService.update(updateLanguageRequest);
}
@PostMapping("/create")
@ResponseStatus(HttpStatus.CREATED)
public void create(@RequestBody CreateLanguageRequest createLanguageRequest){
    this.languageService.create(createLanguageRequest);
}
@DeleteMapping("/delete/{id}")
@ResponseStatus(HttpStatus.OK)
public void delete(Long id){
    this.languageService.delete(id);
}
}


