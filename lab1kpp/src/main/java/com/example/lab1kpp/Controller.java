package com.example.lab1kpp;

import com.example.lab1kpp.ConvertException;
import com.example.lab1kpp.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.LinkedList;


@RestController
public class Controller {
    private static final Logger ErrorLogger = LoggerFactory.getLogger(Controller.class);
    private static final Hash test_hash_map = new Hash();
    private static Count test_count = new Count();

    @GetMapping("/")
    void error() throws Exception {

        ErrorLogger.info("Endpoint: /");
        ErrorLogger.info("Internal server Error!");
        test_count.incrementCounter();
        throw new ConvertException("Invalid endpoint", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/ConvertData")
    public static double func1(@RequestParam(value = "toConvert", defaultValue = "0") double toConvert,
                 @RequestParam(value = "toConvert2", defaultValue = "0") int toConvert2) throws ConvertException {
        ErrorLogger.info("Endpoint: /ConvertData");
        if(toConvert < 0 || toConvert2 < 0) {

            ErrorLogger.info("Bad request.");
            throw new ConvertException("Invalid data ( < 0)", HttpStatus.BAD_REQUEST);

        }
        if(toConvert == 0) {

            test_count.incrementCounter();
            return 0.39 * toConvert2;

        } else {

            test_count.incrementCounter();
            test_hash_map.addToMap(toConvert, (int)(toConvert / 0.39));
            return (int)(toConvert / 0.39);

        }

    }

    @RequestMapping (value = {"/calc"}, method = RequestMethod.POST)
    public List<Double> calculateValues(@RequestBody List<Double> test_list) {

        List<Double> result_list = new LinkedList<>();

        test_list.forEach((currentElement) -> {

            try {
                result_list.add(Controller.func1(currentElement, 0));
            } catch (ConvertException e) {
                e.printStackTrace();
            }

        });
        ErrorLogger.info("Succeful post-mapping");
        return result_list;

    }

    @ExceptionHandler (ConvertException.class)
    public ResponseEntity handleException(ConvertException temp_except) {

        ErrorLogger.info("Exception: ", temp_except.getException());
        Response my_response = new Response(temp_except.getException());
        return new ResponseEntity<>(my_response, temp_except.getStatus());

    }
}
