/*
const likeIcon = document.querySelector(".like-icon");
likeIcon.addEventListener("click",function(){
    this.classList.toggle("fill-icon");
});
*/
/*
const likeIcon = document.querySelector(".like-icon");
likeIcon.addEventListener("click",function(){
    const status = this.innerText;
    if(status == "heart_plus"){
        this.innerText = "favorite";
    } else if(status == "favorite"){
        this.innerText = "heart_plus";
    }
});
*/

/*
const done = document.querySelector(".done");
done.addEventListener("click", function(){
    const todoText = document.querySelector(".todo-text");
    todoText.style.textDecoration="line-through";
});
const delBtn = document.querySelector(".delete");
delBtn.addEventListener("click",function(){
    const del = document.querySelector(".todolist");
    del.remove();
});
*/


const addBtn = document.querySelector(".add-btn");
const input = document.querySelector("[name=input]");

input.addEventListener("keyup",function(e){
    if(e.keyCode == 13){
        addList();
    }
});
    addBtn.addEventListener("click",function(){
    addList();
});

function addList(){
    const inputValue = input.value;

    if(inputValue !=""){
        const todolist = document.createElement("ul");
        todolist.classList.add("todolist");
        //todolist.setAttribute("class","todolist");
        //<ul class = "todolist"></ul>
        const likeLi = document.createElement("li");
        likeLi.classList.add("like");
        //<li class="like"></li>
        const textLi = document.createElement("li");
        textLi.classList.add("todo-text");
        //<li class="todo-text"></li>
        const checkLi = document.createElement("li");
        checkLi.classList.add("check-zone");
       // <li class="check-zone"></li>
    
       const likeSpan = document.createElement("span");
       likeSpan.classList.add("material-symbols-outlined");
       likeSpan.classList.add("like-icon");
    
       likeSpan.addEventListener("click",function(){
        this.classList.toggle("fill-icon");
       });
    
       const likeText = document.createTextNode("favorite");
       likeSpan.appendChild(likeText)
       
      likeSpan.innerText = "favorite";
    
      likeLi.appendChild(likeSpan);
      
      textLi.innerText = inputValue;
    
      const doneSpan = document.createElement("span");
      doneSpan.classList.add("material-symbols-outlined");
      doneSpan.classList.add("done");
      doneSpan.innerText = "done";
    
      doneSpan.addEventListener("click",function(){
        textLi.style.textDecoration = "line-through";
        this.remove();
      });
    
      const deleteSpan = document.createElement("span");
      deleteSpan.classList.add("material-symbols-outlined");
      deleteSpan.classList.add("delete");
      deleteSpan.innerText = "delete";
    
      deleteSpan.addEventListener("click",function(){
        todolist.remove();
      })
    
      checkLi.appendChild(doneSpan);
      checkLi.appendChild(deleteSpan);
    
      todolist.appendChild(likeLi);
      todolist.appendChild(textLi);
      todolist.appendChild(checkLi);
    
      const listBox = document.querySelector(".list-box");
      listBox.appendChild(todolist);

      input.value = "";
    }

   
}