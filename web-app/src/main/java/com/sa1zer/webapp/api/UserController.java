package com.sa1zer.webapp.api;

import com.sa1zer.webapp.annotation.NotNull;
import com.sa1zer.webapp.annotation.Valid;
import com.sa1zer.webapp.entity.User;
import com.sa1zer.webapp.facade.UserFacade;
import com.sa1zer.webapp.payload.dto.OrderDto;
import com.sa1zer.webapp.payload.request.CreateUserRequest;
import com.sa1zer.webapp.payload.request.UpdateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @Operation(description = "Создание пользователя")
    @PostMapping("create")
    public User createUser(@RequestBody @Valid @ParameterObject CreateUserRequest request) {
        return userFacade.createUser(request);
    }

    @Operation(description = "Обновление пользователя")
    @PatchMapping("update")
    public User updateUser(@RequestBody @Valid @ParameterObject UpdateUserRequest request) {
        return userFacade.updateUser(request);
    }

    @Operation(description = "Получение всех заказов пользователя")
    @GetMapping("{id}/orders")
    public List<OrderDto> orders(@PathVariable @Valid @NotNull @Parameter(description = "Id пользователя", required = true) Long id) {
        return userFacade.findAllOrders(id);
    }

    @Operation(description = "Удаление пользователя")
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable @Parameter(description = "Id пользователя", required = true) Long id) {
        return userFacade.delete(id);
    }
}
