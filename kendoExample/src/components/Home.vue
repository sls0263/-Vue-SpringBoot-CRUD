<template>
        <div class="container mt-5">
            <div class='row'>
                <div class='col-12'>
                    <h1 class='welcome mb-0'>Welcome to Kendo UI for Vue</h1>
                    <h2 class='sub-header mt-0'>메인화면이에요</h2>
                </div>
            </div>
            <div class='row'>
                <div class='col-12'>
                    <h1 class='get-started'>Get Started</h1>
                </div>
            </div>
            <div class='row justify-content-center'>
                <div class='col-6 text-right'>
                    <div class='kendoka-div'>
                        <img class='kendoka' src="../assets/images/kendoka-vue.svg" alt='kendoka' />
                    </div>
                </div>
                <div class='col-6 components-list'>
                    <p>
                    <img src="../assets/images/components.svg"  alt='components' /> 
                        <!-- <a href="/Grid">그리드</a> -->
                        <router-link to="/Grid">그리드</router-link>
                    </p>
                    <p>
                        <img src="../assets/images/styles.svg" alt='styles' />
                        <!-- <a href='http://localhost/Chart'>차트</a> -->
                        <router-link to="/Chart">차트</router-link>
                    </p>
                    <p>
                        <img src="../assets/images/blogs.svg" alt='blogs' />
                        <!-- <a href='http://localhost/Form'>Form</a> -->
                        <router-link to="/Form">Form</router-link>
                    </p>
                    <p>
                        <img src="../assets/images/tutorials.svg" alt='tutorials' />
                        <!-- <a href='http://localhost/'>Home</a> -->
                        <router-link to="/ExamGrid">ExamGrid</router-link>
                    </p>
                </div>
            </div>
        </div>
</template>
<script>
import grid from "../components/Grid";
export default {
     data: function() {
        return {
            publicPath: process.env.BASE_URL
        }
    }
}
</script>
