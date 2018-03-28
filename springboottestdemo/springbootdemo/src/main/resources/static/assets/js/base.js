function ajaxRequest(url, data, successCallBack, errorCallBack) {
    $:ajax({
       type:type,
        dataType:"json",
        url:url,
        data:data,
        success:successCallBack,
        error:errorCallBack
    });
}