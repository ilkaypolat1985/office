package com.refactoring.office.controller;

import com.refactoring.office.exception.NotFoundException;
import com.refactoring.office.model.Office;
import com.refactoring.office.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(final OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/offices")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOffice(@Valid @RequestBody Office office) {
        officeService.save(office);
    }

    @GetMapping("/offices")
    @ResponseStatus(HttpStatus.OK)
    public List<Office> getOffices() {
        return officeService.getAll();
    }

    @ExceptionHandler
    public void handleNotFoundException(NotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
