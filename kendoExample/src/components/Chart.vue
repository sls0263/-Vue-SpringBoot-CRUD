<template>
    <div>
      <table>
        <tr>
          <th>제목</th>
          <th>부제</th>
          <th>제작연도</th>
          <th>감독</th>
          <th>배우</th>
          <th>평점</th>
        </tr>
        <tr v-for="item in items" :key="item.title">
          <td><span v-html="item.title"></span></td>
          <td><span v-html="item.subtitle"></span></td>
          <td><span v-html="item.pubDate"></span></td>
          <td><span v-html="item.director"></span></td>
          <td><span v-html="item.actor"></span></td>
          <td><span v-html="item.userRating"></span></td>
        </tr>
      </table>
    </div>
  </template>
   
  <script>
    export default {
      data() {
        return {
          items: [
            {
              "title": "<strong>기생충</strong>",
              "subtitle": "PARASITE",
              "pubDate": "2019",
              "director": "봉준호|",
              "actor": "송강호|이선균|조여정|최우식|박소담|이정은|장혜진|",
              "userRating": "8.49"
            },
            {
              "title": "마약<b>기생충</b>",
              "subtitle": "Running With The Devil",
              "pubDate": "2019",
              "director": "제이슨 카벨|",
              "actor": "니콜라스 케이지|로렌스 피시번|",
              "userRating": "0.00"
            },
            {
              "title": "파라노말 <b>기생충</b>",
              "subtitle": "The Unbelievable Ability",
              "pubDate": "2018",
              "director": "나츠메 타이치로|",
              "actor": "오다지마 나기사|",
              "userRating": "8.00"
            },
            {
              "title": "<b>기생충</b>",
              "subtitle": "A Parasite",
              "pubDate": "2002",
              "director": "박민재|",
              "actor": "신동훈|함승희|이경수|",
              "userRating": "0.00"
            }
          ]
        }
      }
    }
  </script>
   
  <style>
  td, th {
    padding: 10px;
    border: 1px solid #ccc;
  }
  body {
    padding: 1rem;
  }
  </style>