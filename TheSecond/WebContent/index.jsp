<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes" />
<meta name="color-scheme" content="light dark" />
<meta name="theme-color" content="#007bff"
	media="(prefers-color-scheme: light)" />
<meta name="theme-color" content="#1a1a1a"
	media="(prefers-color-scheme: dark)" />
<!--end::Accessibility Meta Tags-->
<!--begin::Primary Meta Tags-->
<meta name="title" content="AdminLTE 4 | Sidebar Mini" />
<meta name="author" content="ColorlibHQ" />
<meta name="description"
	content="AdminLTE is a Free Bootstrap 5 Admin Dashboard, 30 example pages using Vanilla JS. Fully accessible with WCAG 2.1 AA compliance." />
<meta name="keywords"
	content="bootstrap 5, bootstrap, bootstrap 5 admin dashboard, bootstrap 5 dashboard, bootstrap 5 charts, bootstrap 5 calendar, bootstrap 5 datepicker, bootstrap 5 tables, bootstrap 5 datatable, vanilla js datatable, colorlibhq, colorlibhq dashboard, colorlibhq admin dashboard, accessible admin panel, WCAG compliant" />
<!--end::Primary Meta Tags-->
<!--begin::Accessibility Features-->
<!-- Skip links will be dynamically added by accessibility.js -->
<meta name="supported-color-schemes" content="light dark" />
<base href="TheSecond/" />
<link rel="preload" href="../css/adminlte.css" as="style" />
<!--end::Accessibility Features-->
<!--begin::Fonts-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fontsource/source-sans-3@5.0.12/index.css"
	integrity="sha256-tXJfXfp6Ewt1ilPzLDtQnJV4hclT9XuaZUKyUvmyr+Q="
	crossorigin="anonymous" media="print" onload="this.media='all'" />
<!--end::Fonts-->
<!--begin::Third Party Plugin(OverlayScrollbars)-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/overlayscrollbars@2.11.0/styles/overlayscrollbars.min.css"
	crossorigin="anonymous" />
<!--end::Third Party Plugin(OverlayScrollbars)-->
<!--begin::Third Party Plugin(Bootstrap Icons)-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css"
	crossorigin="anonymous" />
<!--end::Third Party Plugin(Bootstrap Icons)-->
<!--begin::Required Plugin(AdminLTE)-->
<link rel="stylesheet" href="../css/adminlte.css" />
<!--end::Required Plugin(AdminLTE)-->
</head>
<!--end::Head-->
<!--begin::Body-->
<body
	class="layout-fixed sidebar-expand-lg sidebar-mini sidebar-collapse bg-body-tertiary">
	<!--begin::App Wrapper-->
	<div class="app-wrapper">
		<!--begin::Header-->
		<nav class="app-header navbar navbar-expand bg-body">
			<!--begin::Container-->
			<div class="container-fluid">
				<!--begin::Start Navbar Links-->
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						data-lte-toggle="sidebar" href="#" role="button"> <i
							class="bi bi-list"></i>
					</a></li>
				</ul>
				<!--end::Start Navbar Links-->
				<!--begin::End Navbar Links-->
				<ul class="navbar-nav ms-auto">

					<!--begin::Fullscreen Toggle-->
					<li class="nav-item"><a class="nav-link" href="#"
						data-lte-toggle="fullscreen"> <i data-lte-icon="maximize"
							class="bi bi-arrows-fullscreen"></i> <i data-lte-icon="minimize"
							class="bi bi-fullscreen-exit" style="display: none"></i>
					</a></li>
					<!--end::Fullscreen Toggle-->
					<!--begin::User Menu Dropdown-->
					<li class="nav-item dropdown user-menu"><a href="#"
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"> <img
							src="../assets/img/avatar5.png"
							class="user-image rounded-circle shadow" alt="User Image" />
							 
<%
 String fullName = (String) session.getAttribute("userFullName");
 String role = (String) session.getAttribute("userRole");

 if (fullName != null) {
 	// เก็บลงใน Scope เพื่อให้ JSTL เรียกใช้ได้ 
 	pageContext.setAttribute("fullName", fullName);
 	pageContext.setAttribute("userRole", role);

 	out.print("<span class=\"d-none d-md-inline\">" + fullName + "</span>");
 }
 %>
</a>
						<ul class="dropdown-menu dropdown-menu-lg dropdown-menu-end">
							<!--begin::User Image-->
							<li class="user-header text-bg-primary"><img
								src="../assets/img/avatar5.png" class="rounded-circle shadow"
								alt="User Image" />
								<p>${fullName} | ${userRole}</p>
								</li>
							<!--end::User Image-->
							<!--begin::Menu Body-->
							<li class="user-body"></li>
							<!--end::Menu Body-->
							<!--begin::Menu Footer-->
							<li class="user-footer"><a href="../profile.jsp"
								class="btn btn-default btn-flat">Profile</a> <a
								href="../logout.jsp" class="btn btn-default btn-flat float-end">Sign
									out</a></li>
							<!--end::Menu Footer-->
						</ul></li>
					<!--end::User Menu Dropdown-->
				</ul>
				<!--end::End Navbar Links-->
			</div>
			<!--end::Container-->
		</nav>


<style>
/* =================================================
   APPLE-LIKE / PREMIUM THEME (SAFE VERSION)
================================================= */
:root {
  --primary: #0a84ff;
  --text-main: #0f172a;
  --text-sub: #64748b;
  --glass-bg: rgba(255,255,255,.72);
  --glass-border: rgba(0,0,0,.08);
}

body {
  font-family: -apple-system, BlinkMacSystemFont, "SF Pro Display",
               "Source Sans 3", sans-serif;
  background:
    radial-gradient(circle at top right, #eaf2ff, transparent 45%),
    linear-gradient(180deg, #f8fafc, #eef2f7);
  color: var(--text-main);
}

/* ================= HEADER : WHITE GLASS ================= */
.app-header.navbar {
  background: rgba(255,255,255,0.88) !important;
  backdrop-filter: blur(14px) saturate(160%);
  -webkit-backdrop-filter: blur(14px) saturate(160%);
  border-bottom: 1px solid rgba(0,0,0,0.08);
  box-shadow: 0 8px 24px rgba(0,0,0,0.08);
}

.app-header .nav-link,
.app-header span,
.app-header i {
  color: #0f172a !important;
}

.app-header .nav-link:hover {
  background: rgba(0,0,0,0.05);
  border-radius: 10px;
}

/* ================= SIDEBAR ================= */
.app-sidebar {
  background: linear-gradient(180deg, #0f172a, #020617) !important;
}

.sidebar-brand {
  border-bottom: 1px solid rgba(255,255,255,.08);
}

.sidebar-menu .nav-link {
  border-radius: 12px;
  margin: 6px 10px;
  transition: all .3s ease;
}

.sidebar-menu .nav-link:hover {
  background: rgba(255,255,255,.08);
  transform: translateX(4px);
}

.sidebar-menu .nav-link.active {
  background: linear-gradient(90deg, #0a84ff, #38bdf8);
  box-shadow: 0 8px 20px rgba(10,132,255,.45);
}

/* ================= CONTENT HEADER ================= */
.app-content-header {
  position: relative;
  padding: 40px 20px 80px;
}

.app-content-header h3 {
  font-size: 2rem;
  font-weight: 700;
  letter-spacing: -.02em;
}

/* ===== WELCOME GLASS CARD ===== */
.app-content-header h4 {
  position: absolute;
  top: 20px;
  right: 20px;
  padding: 16px 26px;
  border-radius: 20px;
  background: var(--glass-bg);
  backdrop-filter: blur(14px) saturate(160%);
  -webkit-backdrop-filter: blur(14px) saturate(160%);
  border: 1px solid var(--glass-border);
  box-shadow:
    0 20px 40px rgba(0,0,0,.12),
    inset 0 1px 0 rgba(255,255,255,.6);
  font-size: 1.05rem;
  font-weight: 600;
  color: var(--text-main);
  white-space: nowrap;
}

/* ================= CARD ================= */
.card {
  border-radius: 24px;
  border: none;
  background: #fff;
  box-shadow: 0 30px 60px rgba(0,0,0,.08);
  transition: all .35s ease;
}

.card:hover {
  transform: translateY(-6px);
  box-shadow: 0 40px 80px rgba(0,0,0,.12);
}

.card img {
  border-radius: 20px;
  transition: transform .5s ease;
}

.card img:hover {
  transform: scale(1.04);
}

/* ================= BUTTON ================= */
.btn-primary {
  background: linear-gradient(180deg, #0a84ff, #006edc);
  border: none;
  border-radius: 999px;
  padding: 14px 38px;
  font-size: 1.05rem;
  font-weight: 600;
  box-shadow:
    0 14px 30px rgba(10,132,255,.45),
    inset 0 1px 0 rgba(255,255,255,.5);
  transition: all .35s ease;
}

.btn-primary:hover {
  transform: translateY(-3px);
  box-shadow:
    0 22px 45px rgba(10,132,255,.65),
    inset 0 1px 0 rgba(255,255,255,.7);
}

/* ================= FOOTER ================= */
.app-footer {
  background: transparent;
  color: var(--text-sub);
}

.app-footer a {
  color: var(--primary);
  font-weight: 600;
}

/* ================= RESPONSIVE ================= */
@media (max-width: 768px) {
  .app-content-header h4 {
    position: static;
    margin-top: 16px;
    width: fit-content;
  }
}
</style>
</head>


<aside class="app-sidebar shadow" data-bs-theme="dark">
<div class="sidebar-brand">
<a href="../index.jsp" class="brand-link">
<img src="../assets/img/meow/logo4.png" class="brand-image" />
<span class="brand-text">The Second</span>
</a>
</div>

<div class="sidebar-wrapper">
				<nav class="mt-2">
					<!--begin::Sidebar Menu-->
					<ul class="nav sidebar-menu flex-column" data-lte-toggle="treeview"
						role="navigation" aria-label="Main navigation"
						data-accordion="false" id="navigation">
						<li class="nav-item"><a href="../index.jsp"
							class="nav-link active"> <i
								class="nav-icon bi bi-speedometer"></i>
								<p>Home</p>
						</a></li>

						<li class="nav-item"><a href="../bookings.jsp"
							class="nav-link"> <i class="nav-icon bi bi-book"></i>
								<p>Bookings</p>
						</a></li>

						<c:if test="${userRole == 'admin'}">
							<li class="nav-item"><a href="#" class="nav-link"> <i
									class="nav-icon bi bi-box-seam-fill"></i>
									<p>
										Master Data <i class="nav-arrow bi bi-chevron-right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a href="../rooms.jsp"
										class="nav-link"> <i class="nav-icon bi bi-circle"></i>
											<p>Rooms</p>
									</a></li>
									<li class="nav-item"><a href="../users.jsp"
										class="nav-link"> <i class="nav-icon bi bi-circle"></i>
											<p>Users</p>
									</a></li>
								</ul></li>
						</c:if>
					</ul>
					<!--end::Sidebar Menu-->
				</nav>
			</div>
			<!--end::Sidebar Wrapper-->
		</aside>
		<!--end::Sidebar-->
		<!--begin::App Main-->

<main class="app-main">
<div class="app-content-header container-fluid">
<h3>Home</h3>
</div>

<div class="container-fluid">
<div class="card">
<div class="card-body text-center">
<img src="../assets/img/meow/room1.jpg" class="img-fluid mb-4" />
<br>
<a href="../create_booking.jsp" class="btn btn-primary">Book Now</a>
</div>
</div>
</div>
</main>

<footer class="app-footer text-center">
<a href="https://line.me/ti/g/56m9CJab_R">Contact us</a>
</footer>

</div>

<script
		src="https://cdn.jsdelivr.net/npm/overlayscrollbars@2.11.0/browser/overlayscrollbars.browser.es6.min.js"
		crossorigin="anonymous"></script>
	<!--end::Third Party Plugin(OverlayScrollbars)-->
	<!--begin::Required Plugin(popperjs for Bootstrap 5)-->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		crossorigin="anonymous"></script>
	<!--end::Required Plugin(popperjs for Bootstrap 5)-->
	<!--begin::Required Plugin(Bootstrap 5)-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.min.js"
		crossorigin="anonymous"></script>
	<!--end::Required Plugin(Bootstrap 5)-->
	<!--begin::Required Plugin(AdminLTE)-->
	<script src="../js/adminlte.js"></script>
	<!--end::Required Plugin(AdminLTE)-->
	<!--begin::OverlayScrollbars Configure-->
	<script>
      const SELECTOR_SIDEBAR_WRAPPER = '.sidebar-wrapper';
      const Default = {
        scrollbarTheme: 'os-theme-light',
        scrollbarAutoHide: 'leave',
        scrollbarClickScroll: true,
      };
      document.addEventListener('DOMContentLoaded', function () {
        const sidebarWrapper = document.querySelector(SELECTOR_SIDEBAR_WRAPPER);
        if (sidebarWrapper && OverlayScrollbarsGlobal?.OverlayScrollbars !== undefined) {
          OverlayScrollbarsGlobal.OverlayScrollbars(sidebarWrapper, {
            scrollbars: {
              theme: Default.scrollbarTheme,
              autoHide: Default.scrollbarAutoHide,
              clickScroll: Default.scrollbarClickScroll,
            },
          });
        }
      });
    </script>
	<!--end::OverlayScrollbars Configure-->
	<!--end::Script-->
</body>
<!--end::Body-->
</html>
