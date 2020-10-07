package chelsea.firstone.social.Exceptions;

import chelsea.firstone.social.user.User;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable th) {
        super(th);
    }

    public BusinessException(String msg){
        super(msg);
    }

    }

