import PageList from 'components/PageList'
import React, { useEffect, useState } from 'react'
import { fetchPage } from 'todo/service/todo.service'
import TodoInput from './TodoInput'
import TodoList from './TodoList'
import TodoRead from './TodoRead'
import TodoSearch from './TodoSearch'

const initState={
    page : 1,
    size : 10,
    type : '',
    keyword : ''
}

const TodoWrapper = ()=>{
    const [cri, setCri] = useState(initState)

    const [current, setCurrent] = useState(0)

    const [result, setResult] = useState({})

    const loadPage = async()=>{
        const result = await fetchPage(cri)

        setResult(result)
    }

    const movePage = (pageNum)=>{
        setCri({...cri, page : pageNum})
    }

    const moveRead =(tno)=>{
        setCurrent(tno)
    }

    const changeCri = (key, value) =>{
         console.log("changeCri", key, value)

         cri.type = key
         cri.keyword = value
         
         console.log(cri)

         setCri({...cri})
    }

    const clearCri = ()=>{
        setCri({...initState})
    }

    useEffect(()=>{
        loadPage()
    }, [cri])

    return(
        
        <div>
            <TodoInput callback ={clearCri}></TodoInput>

            <TodoSearch {...cri} clearCri={clearCri} changeCri={changeCri}></TodoSearch>

            <TodoList {...result} moveRead={moveRead}></TodoList>

            <PageList {...result} movePage={movePage}></PageList>

            <TodoRead tno={current} clearCri={clearCri}></TodoRead>
        </div>
        
        )

}

export default TodoWrapper