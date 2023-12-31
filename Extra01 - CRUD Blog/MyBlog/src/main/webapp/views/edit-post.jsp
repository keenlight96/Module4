<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Travel | Create a post</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Swiper slider-->
    <link rel="stylesheet" href="../vendor/swiper/swiper-bundle.min.css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.theme.default.min.css">
    <!-- Google fonts-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:300,400&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abril+Fatface&amp;display=swap">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="../css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="../css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="../img/favicon.png">
  </head>
  <body>
    <!-- Header-->
    <header class="header">
      <!-- Top bar -->
      <div class="py-2 bg-dark text-white">
        <div class="container py-1">
          <div class="row align-items-center">
            <div class="col-lg-4">
              <ul class="list-inline mb-0 text-sm">
                <li class="list-inline-item"><a class="reset-anchor" href="#!">About us</a></li>
                <li class="list-inline-item">|</li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!">Sitemap</a></li>
              </ul>
            </div>
            <div class="col-lg-4 d-none d-lg-block text-center">
              <ul class="list-inline mb-0 small">
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-facebook-f"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-twitter"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-instagram"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-youtube"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-vimeo-v"></i></a></li>
              </ul>
            </div>
            <div class="col-lg-4 d-none d-lg-block text-end">
              <div class="dropdown text-sm"><a class="reset-anchor dropdown-toggle" id="destinations" href="#" data-bs-toggle="dropdown" data-bs-display="static" aria-haspopup="true" aria-expanded="false"><i class="fas fa-globe-americas me-2"></i>Destinations</a>
                <div class="dropdown-menu dropdown-menu-end mt-3" aria-labelledby="destinations"><a class="dropdown-item text-sm" href="#!">France</a><a class="dropdown-item text-sm" href="#!">Germany</a><a class="dropdown-item text-sm" href="#!">Spain</a><a class="dropdown-item text-sm" href="#!">Egypt</a><a class="dropdown-item text-sm" href="#!">Thailand</a><a class="dropdown-item text-sm" href="#!">Indonesia</a><a class="dropdown-item text-sm" href="#!">Maldives</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Navbar 1 -->
      <nav class="navbar navbar-expand-lg navbar-light bg-white py-4">
        <div class="container text-center"><a class="navbar-brand mx-auto" href="../index.html"><img class="mb-2" src="../img/logo.svg" alt="" width="140">
            <p class="text-sm text-uppercase text-gray mb-0">Your next pocket travel guide</p></a></div>
      </nav>
      <!-- Navbar 2 -->
      <nav class="navbar navbar-expand-lg navbar-light border-gray py-2 bg-light">
        <div class="container">
          <button class="navbar-toggler navbar-toggler-right mx-auto border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse text-center" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto">
              <li class="nav-item px-1">
                <!-- Link--><a class="nav-link" href="../index.html">Home</a>
              </li>
              <li class="nav-item px-1">
                <!-- Link--><a class="nav-link" href="../post.html">Post</a>
              </li>
              <li class="nav-item px-1">
                <!-- Link--><a class="nav-link active" href="../listing.html">Create</a>
              </li>
              <li class="nav-item px-1 dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Pages</a>
                <div class="dropdown-menu text-center text-lg-start shadow-sm" aria-labelledby="navbarDropdownMenuLink"><a class="dropdown-item" href="../index.html">Home</a><a class="dropdown-item" href="../listing.html">Category</a><a class="dropdown-item" href="../post.html">Post</a></div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    <section class="py-5">
      <div class="container">
        <div class="row gy-5">
          <div class="col-lg-8">
            <h3 class="h4 mb-4">Edit current post</h3>
            <form class="mb-5" action="/edit" method="post">
              <div class="row gy-3">
                <div class="col-lg-12" hidden="hidden">
                  <input class="form-control" type="text" name="id" value="${post.id}">
                </div>
                <div class="col-lg-12">
                  <input class="form-control" type="text" name="title" value="${post.title}">
                </div>
                <div class="col-lg-12">
                  <input class="form-control" type="text" name="thumbnail" value="${post.thumbnail}">
                </div>
                <div class="col-lg-12">
                  <textarea class="form-control" name="content" rows="5" value="${post.content}"></textarea>
                </div>
                <div class="col-lg-12">
                  <button class="btn btn-dark" type="submit">Edit</button>
                </div>
              </div>
            </form>
          </div>
          <div class="col-lg-4">
            <!-- About me widget -->
            <div class="mb-5 text-center"><img class="mb-3 rounded-circle img-thumbnail shadow-sm" src="../img/author.jpg" alt="" width="110">
              <h3 class="h4">About me</h3>
              <p class="text-sm text-muted px-sm-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</p><img class="d-block mx-auto mb-3" src="../img/signature.png" alt="" width="60">
              <ul class="list-inline text-sm mb-0">
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-facebook-f"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-twitter"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-instagram"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-youtube"></i></a></li>
                <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-vimeo-v"></i></a></li>
              </ul>
            </div>
            <!-- Categories widget -->
            <div class="mb-5 text-center"><a class="category reset-anchor bg-cover bg-center mb-2" href="#!" style="background: url(../img/category-1.jpg)">
                <p class="category-title text-uppercase small">Lifestyle</p></a><a class="category reset-anchor bg-cover bg-center mb-2" href="#!" style="background: url(../img/category-2.jpg)">
                <p class="category-title text-uppercase small">Travel</p></a><a class="category reset-anchor bg-cover bg-center" href="#!" style="background: url(../img/category-3.jpg)">
                <p class="category-title text-uppercase small">Vacation</p></a></div>
            <!-- Newsletter widget -->
            <div class="px-4 py-5 bg-light mb-5 text-center">
              <h3 class="h5"><i class="far fa-envelope me-2"></i>Join the family</h3>
              <p class="text-sm text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</p>
              <form action="#">
                <div class="mb-1">
                  <input class="form-control form-control-sm" type="email" name="email" placeholder="Emaill address">
                </div>
                <div class="mb-0">
                  <button class="btn btn-dark w-100 btn-sm" type="submit">Subscribe</button>
                </div>
              </form>
            </div>
            <!-- Latest posts widget -->
            <div class="mb-5">
              <h3 class="h5">Latest posts</h3>
              <p class="text-sm text-muted mb-4">Lorem ipsum dolor sit, consectetur adipisicing elit, sed do eiusmod.</p>
              <ul class="list-unstyled">
                <li class="d-flex mb-1"><a href="../post.html"><img src="../img/recent-posts-thumb-1.jpg" alt="" width="80"></a>
                  <div class="media-body ms-3">
                    <p class="small text-primary text-uppercase mb-0">5 Aug 2018</p>
                    <h6 class="mb-1"><a class="reset-anchor" href="../post.html">The top climbing tours</a></h6>
                    <p class="small text-muted">Lorem ipsum dolor sit, consectetur adipisicing elit, sed.</p>
                  </div>
                </li>
                <li class="d-flex mb-1"><a href="../post.html"><img src="../img/recent-posts-thumb-2.jpg" alt="" width="80"></a>
                  <div class="media-body ms-3">
                    <p class="small text-primary text-uppercase mb-0">5 Aug 2018</p>
                    <h6 class="mb-1"><a class="reset-anchor" href="../post.html">Travel guide to Canada</a></h6>
                    <p class="small text-muted">Lorem ipsum dolor sit, consectetur adipisicing elit, sed.</p>
                  </div>
                </li>
                <li class="d-flex mb-1"><a href="../post.html"><img src="../img/recent-posts-thumb-3.jpg" alt="" width="80"></a>
                  <div class="media-body ms-3">
                    <p class="small text-primary text-uppercase mb-0">5 Aug 2018</p>
                    <h6 class="mb-1"><a class="reset-anchor" href="../post.html">A day in Tailand</a></h6>
                    <p class="small text-muted">Lorem ipsum dolor sit, consectetur adipisicing elit, sed.</p>
                  </div>
                </li>
              </ul>
            </div>
            <!-- Instagram widget -->
            <div class="mb-5">
              <h3 class="h5">Follow on Instagram</h3>
              <p class="text-sm text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</p>
              <div class="row gx-0">
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-1.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-2.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-3.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-4.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-5.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-6.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-8.jpg" alt=""></div></a></div>
                <div class="col-3"><a class="instagram-item overlay-hover-dark-sm d-block w-100" href="#!">
                    <div class="overlay-content"><img class="img-fluid" src="../img/instagram-1.jpg" alt=""></div></a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer class="bg-dark py-4">
      <div class="container">
        <div class="row py-2 gy-2">
          <div class="col-lg-4 text-center text-lg-start">
            <p class="small text-muted text-uppercase mb-0">&copy; copyright 2021 - all rights reserved</p>
          </div>
          <div class="col-lg-4 text-center">
            <ul class="list-inline text-white small mb-0">
              <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-facebook-f"></i></a></li>
              <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-twitter"></i></a></li>
              <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-instagram"></i></a></li>
              <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-youtube"></i></a></li>
              <li class="list-inline-item"><a class="reset-anchor" href="#!"><i class="fab fa-vimeo-v"></i></a></li>
            </ul>
          </div>
          <div class="col-lg-4 text-center text-lg-end">
            <p class="small text-muted text-uppercase mb-0">Template designed by <a href="https://bootstrapious.com/p/bootstrap-travel-blog-template">Bootstrapious</a>. </p>
            <!-- If you want to remove the backlink, please purchase the Attribution-Free License. See details in readme.txt or license.txt. Thanks!-->
          </div>
        </div>
      </div>
    </footer>
    <!-- JavaScript files-->
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../vendor/swiper/swiper-bundle.min.js"></script>
    <script src="../js/front.js"></script>
    <script>
      // ------------------------------------------------------- //
      //   Inject SVG Sprite - 
      //   see more here 
      //   https://css-tricks.com/ajaxing-svg-sprite/
      // ------------------------------------------------------ //
      function injectSvgSprite(path) {
      
          var ajax = new XMLHttpRequest();
          ajax.open("GET", path, true);
          ajax.send();
          ajax.onload = function(e) {
          var div = document.createElement("div");
          div.className = 'd-none';
          div.innerHTML = ajax.responseText;
          document.body.insertBefore(div, document.body.childNodes[0]);
          }
      }
      // this is set to BootstrapTemple website as you cannot 
      // inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
      // while using file:// protocol
      // pls don't forget to change to your domain :)
      injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg'); 
      
    </script>
    <!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  </body>
</html>