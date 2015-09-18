package marcos2250.exemploweb.rest;

import marcos2250.exemploweb.dominio.MensagemDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MensagemDTO handleMessagingException(Exception ex) {
        MensagemDTO msg = new MensagemDTO();
        msg.setMensagem(ex.getCause().getMessage());
        return msg;
    }

}
