package marcos2250.exemploweb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import marcos2250.exemploweb.dominio.MensagemDTO;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MensagemDTO handleMessagingException(Exception ex) {
        ex.printStackTrace();
        MensagemDTO msg = new MensagemDTO();
        if (ex.getCause() == null) {
            msg.setMensagem(ex.getMessage());
        } else {
            msg.setMensagem(ex.getCause().getMessage());
        }
        return msg;
    }

}
