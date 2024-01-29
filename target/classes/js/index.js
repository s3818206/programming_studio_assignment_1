document.getElementById('navbar').innerHTML = `<div
        class="container-fluid d-flex flex-row justify-content-between align-items-center">
        <a class="navbar-brand ms-5 fs-3" href="/">Climate Insight</a>
        <ul class="navbar-nav mb-lg-0">
            <li class="nav-item mx-3">
                <a class="nav-link fs-5" href="/about-us">About Us</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link fs-5" href="/dashboard">Dashboard</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link fs-5" href="/news">News</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link fs-5" href="/contact">Contact</a>
            </li>
        </ul>
        <!-- TODO: Seaching functionality may change based GET and POST  requests -->
        <form class="d-flex me-5" role="search">
            <input
                class="form-control me-2 fs-5"
                type="search"
                placeholder="Search"
                aria-label="Search" />
            <button class="btn btn-primary fs-5" type="submit">
                Search
            </button>
        </form>
        </div>`;
