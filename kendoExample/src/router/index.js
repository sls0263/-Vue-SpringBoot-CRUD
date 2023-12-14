import { createWebHistory, createRouter } from "vue-router";
import Home from "../components/Home";

import Grid from "../components/Grid";

import Form from "../components/Form";

import Chart from "../components/Chart";
import NotFound from "../components/NotFound";

import ExamGrid from "../components/ecoDev/ExamGrid";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  }
  ,{
    path: "/Grid",
    name: "Grid",
    component: Grid
  }
  ,{
    path: "/Form",
    name: "Form",
    component: Form
  }
  ,{
    path: "/Chart",
    name: "Chart",
    component: Chart
  }
  ,{
    path: "/notFound",
    name: "notFound",
    component: NotFound
  }
  ,{
    path: "/ExamGrid",
    name: "ExamGrid",
    component: ExamGrid
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
