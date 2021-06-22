import React, { useState } from 'react'
import { registerTodo } from 'todo/service/todo.service'

const initState ={
    title : '',
    content : ''
}

const TodoInput=({callback})=>{
    const [todo, setTodo] =useState(initState)

    const changeTodo=(e)=>{
        const {name, value} = e.target
        
        todo [name] = value

        setTodo({...todo})
    }

    const addTodo=async()=>{
        const response  = await registerTodo(todo)

        console.log(response)

        if(callback){
            callback()
            setTodo({title : '', content :''})
        }

 
    }

    return(<>
        <div>
        <h3>Todo Input</h3>
        <input type="text" name='title' value={todo.title} onChange={(e)=>changeTodo(e)}/>

        <input type="text" name="content" value={todo.content} onChange={(e)=>changeTodo(e)}/>
        
        <button onClick={() => addTodo()}>Add</button>
        </div>
       

    </>)

}

export default TodoInput