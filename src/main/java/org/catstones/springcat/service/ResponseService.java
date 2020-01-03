package org.catstones.springcat.service;

import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author An Nyeong
 */
@Service
public class ResponseService {

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResultFromIterable(Iterable<T> iter) {
        List<T> list = new ArrayList<>();
        iter.forEach(list::add);
        return getListResult(list);
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    public BaseResult getFailResult(String message) {
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    public BaseResult getSuccessResult() {
        BaseResult result = new BaseResult();
        setSuccessResult(result);
        return result;
    }

    private void setSuccessResult(BaseResult result) {
        result.setSuccess(true);
        result.setMessage("");
    }
}
