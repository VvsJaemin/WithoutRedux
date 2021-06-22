import { combineReducers, configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import logger from "redux-logger";
import { todoSlice } from "todo/reducer/todoSlice";

const rootReducer= combineReducers({
    todoSlice
})

export default configureStore({
   reducer : rootReducer,
   middleware:[...getDefaultMiddleware(), logger]
})