package br.com.start;

import com.google.gson.Gson;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by luismoro on 09/09/15.
 */
@Api(value = "Start", description = "Start Services")
@RestController
public class StartController {

    @Autowired
    StartService startService;

    //GET /
    @ApiOperation(value = "Start", notes = "Show the status of the application", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK!", response = String.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NOT FOUND!"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "BAD REQUEST!", response = String.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL SERVER ERROR!", response = String.class) })
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> start() {

        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();

        jsonObject.addProperty("Status", startService.aplicacaoRodando());

        return new ResponseEntity<String>(gson.toJson(jsonObject), HttpStatus.OK);

    }

}
