window.onload = function() {
    const icons = document.querySelectorAll('.icon');

    for (let i = 0; i < icons.length; i++) {
      const icon = icons[i];
  
      icon.addEventListener('click', () => {
        const text = icon.querySelector('.txt');
        const activeText = icon.querySelector('.left_icon');
   
        if (text.classList.contains('txt')) {
          document.querySelector('.active_txt').classList.add('txt');
          document.querySelector('.active_txt').classList.remove('active_txt');
          document.querySelector('.active').classList.add('left_icon');
          document.querySelector('.active').classList.remove('active');
          text.classList.remove('txt');
          text.classList.add('active_txt');
          activeText.classList.add('active');
          activeText.classList.remove('left_icon');

        } 
        // 调用 updatePage 函数，传递该 icon 元素的索引值
        //updatePage(i);
      });
    }
    
    //right1 button
    const liElements = document.querySelectorAll('.page_button li');
    console.log(liElements);
    liElements.forEach((li,index) => {
      li.addEventListener('click', () => {
         if(li.classList.contains("normal"))
         {
            let liElements = document.querySelector('.page_button .active').classList.add("normal");
            liElements = document.querySelector('.page_button .active').classList.remove("active");
            li.classList.add("active");
            li.classList.remove("normal");
         }
      });
    });

  }