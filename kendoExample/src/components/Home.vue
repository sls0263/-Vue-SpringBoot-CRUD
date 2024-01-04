<template>
        <div class="container mt-5">
            <div class='row'>
                <div class='col-12'>
                    <h1 class='welcome mb-0'>Welcome to Admin Page for Vue</h1>
                    <h2 class='sub-header mt-0'>메인화면</h2>
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
                        <img src="../assets/images/blogs.svg" alt='blogs' />
                        <!-- <a href='http://localhost/Form'>Form</a> -->
                        <router-link to="/menu">menu</router-link>
                    </p>
                    <p>
                        <img src="../assets/images/tutorials.svg" alt='tutorials' />
                        <!-- <a href='http://localhost/'>Home</a> -->
                        <router-link to="/MenuMgmt">MenuMgmt</router-link>
                    </p>
                </div>
            </div>
        </div>
</template>
<script>
export default {
     data: function() {
        return {
            publicPath: process.env.BASE_URL
        }
    }
}
</script>
