Confirm = {
  show:function(message,callback){
    swal.fire({
      title: '确认?',
      text: message,
      icon: 'warning',
      showCancelButton: true,
      cancelButtonText: '取消',
      confirmButtonText: '删除',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        if(callback){
          callback();
        }

      }
    })

  }
}