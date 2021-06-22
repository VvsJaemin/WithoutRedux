import React, {useCallback, useEffect, useState} from 'react';
import {fetchRead, modify, remove} from "todo/service/todo.service";

const initState = {
    tno:0,
    title:'',
    content:'',
    regDate:'',
    modDate:''
}

const TodoRead = ({tno, clearCri}) => {

    const [todo, setTodo] = useState(initState)

    const change = useCallback((e) => {
        e.preventDefault()
        e.stopPropagation()
        const target = e.target
        todo[target.name] = target.value

        setTodo({...todo})
    })

    const clickModify = () => {

        modify(todo).then(result => {
            clearCri()
            setTodo({...initState})
        })

    }

    const clickRemove = () => {

        remove(todo.tno).then(result => {
            clearCri()
            setTodo({...initState})
        })
    }



    useEffect(() => {

        console.log("todoRead", tno)

        if(tno === 0) { return }

        fetchRead(tno).then(todoObj => setTodo(todoObj))

    },[tno])

    return (
        <div>
            <h4>Todo Read/Modify/Remove</h4>
            <div>
                <input type={'text'} name={'tno'} value={todo.tno} onChange={change}/>
            </div>
            <div>
                <input type={'text'} name={'title'} value={todo.title}  onChange={change}/>
            </div>
            <div>
                <input type={'text'} name={'content'} value={todo.content}  onChange={change}/>
            </div>
            <div>
                <input type={'text'} name={'regDate'} value={todo.regDate}  onChange={change}/>
            </div>
            <div>
                <input type={'text'} name={'modDate'} value={todo.modDate}  onChange={change}/>
            </div>
            <div>
                <button onClick={() => clickModify() }>MODIFY</button>
                <button onClick={() => clickRemove() }>REMOVE</button>
            </div>
        </div>
    );
};

export default TodoRead;