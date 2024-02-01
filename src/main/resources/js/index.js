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

document.getElementById(
    'dashboardSidebar',
).innerHTML = `<div class="flex-shrink-0 p-3">
            <ul class="list-unstyled ps-0">
                <li class="mb-1">
                    <button
                        class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                        data-bs-toggle="collapse"
                        data-bs-target="#home-collapse"
                        aria-expanded="true">
                        <h6>Shallow-Glance Data</h6>
                    </button>
                    <div class="collapse show" id="home-collapse">
                        <ul
                            class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li>
                                <a
                                    href="/dashboard"
                                    class="link-body-emphasis d-inline-flex text-decoration-none rounded">
                                    Temperature and Population
                                    changed by Country/Global
                                </a>
                            </li>
                            <li>
                                <a
                                    href="/dashboard_s2b"
                                    class="link-body-emphasis d-inline-flex text-decoration-none rounded">
                                    Temperature changed by
                                    City/State
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button
                        class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
                        data-bs-toggle="collapse"
                        data-bs-target="#dashboard-collapse"
                        aria-expanded="false">
                        <h6>Deep-dive Data</h6>
                    </button>
                    <div class="collapse" id="dashboard-collapse">
                        <ul
                            class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li>
                                <a
                                    href="/dashboard_s3a"
                                    class="link-body-emphasis d-inline-flex text-decoration-none rounded">
                                    Temperature Change over Extended
                                    Periods
                                </a>
                            </li>
                            <li>
                                <a
                                    href="/dashboard_s3b"
                                    class="link-body-emphasis d-inline-flex text-decoration-none rounded">
                                        Time Periods with
                                    Similar Temperature and/or
                                    Population
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>`;

/* global bootstrap: false */
(() => {
    'use strict';
    const tooltipTriggerList = Array.from(
        document.querySelectorAll('[data-bs-toggle="tooltip"]'),
    );
    tooltipTriggerList.forEach((tooltipTriggerEl) => {
        new bootstrap.Tooltip(tooltipTriggerEl);
    });
})();


