<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>shop</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="./css/search.css" />
  </head>
  <body>
    <!-- 상단 바 -->
    <header>
      <div class="logo">
        <a href="../index.html" id="selected">BT</a>
      </div>
      <nav class="shop-nav">
        <a href="../shop_detail/detail.html">Fashion</a>
        <a href="#">Make Up</a>
        <a href="#">Accessory</a>
        <a href="#" id="selected">검색</a>
      </nav>
      <nav class="shop-nav__info">
        <a href="../shop_my/mypage.html">MY</a>
        <a href="#">Login</a>
      </nav>
    </header>
    <div class="box">
      <a id="noice__board">검색</a>
    </div>
    <!-- 메인 -->
    <div class="wrap">
      <div class="search__box--cotainer">
        <div class="search__box">
          <input type="text" placeholder="제목을 입력하세요" />
          <p class="search__box--icon">&#128269;</p>
        </div>
      </div>
      <div id="shop__header--photoBox" class="shop__header--photoBox">
        <div class="carousel">
          <img
            src="https://img.etnews.com/news/article/2021/10/02/cms_temp_article_02224619369582.png"
            alt="Slide 1"
          />
          <img
            src="https://news.samsungdisplay.com/wp-content/uploads/2022/08/3.png"
            alt="Slide 2"
          />
          <img
            src="https://images.moneycontrol.com/static-mcnews/2022/08/samsung-z-flip-4.jpg?impolicy=website&width=1600&height=900"
            alt="Slide 3"
          />
        </div>
        <div class="slide__count-box">
          <div class="arrow prev" onclick="prevSlide()">❮</div>
          <div class="counter">1 / 3</div>
          <div class="arrow next" onclick="nextSlide()">❯</div>
        </div>
      </div>
      <!-- 좌측 -->
      <div id="shop__main--box" class="shop__main--box">
        <div class="shop__main--styleBox">
          <div class="shop__main--seasonBox">
            <div class="shop__code--titleBox"></div>
            <div class="shop__code--Box">
              <div class="shop__code--product">
                <img
                  src="https://m.gifteabox.com/web/product/big/202209/9ba87936e31b29ebdd3769ff8e9c226f.jpg"
                  alt="code-image"
                />
                <p class="shop__code--content">가을 코디</p>
              </div>
              <div class="shop__code--product">
                <img
                  src="https://m.youngcode.kr/web/product/big/202109/fae83f9866375e7bc69866a3732ac30b.jpg"
                  alt="code-image"
                />
                <p class="shop__code--content">초 가을 바람 막이</p>
              </div>
              <div class="shop__code--product">
                <div class="shop__code--ready">
                  <p>상품 준비중</p>
                </div>
              </div>
              <div class="shop__code--product">
                <div class="shop__code--ready">
                  <p>상품 준비중</p>
                </div>
              </div>
            </div>
            <div class="shop__code--Box" style="margin: 106px 0px">
              <div class="shop__code--product">
                <img
                  src="https://m.gifteabox.com/web/product/big/202209/9ba87936e31b29ebdd3769ff8e9c226f.jpg"
                  alt="code-image"
                />
                <p class="shop__code--content">가을 코디</p>
              </div>
              <div class="shop__code--product">
                <img
                  src="https://m.youngcode.kr/web/product/big/202109/fae83f9866375e7bc69866a3732ac30b.jpg"
                  alt="code-image"
                />
                <p class="shop__code--content">초 가을 바람 막이</p>
              </div>
              <div class="shop__code--product">
                <div class="shop__code--ready">
                  <p>상품 준비중</p>
                </div>
              </div>
              <div class="shop__code--product">
                <div class="shop__code--ready">
                  <p>상품 준비중</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="./script.js"></script>
  </body>
</html>
