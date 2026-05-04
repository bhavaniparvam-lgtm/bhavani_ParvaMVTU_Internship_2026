import React from 'react';
import { NavLink } from 'react-router-dom';

function Navbar() {
  return (
    <header className="topbar">
      <div className="brand-section">
        <div className="brand-logo">L</div>
        <div>
          <h1 className="brand-title">Library Management System</h1>
          <p className="brand-subtitle">Spring Boot + React + MySQL</p>
        </div>
      </div>

      <nav className="nav-links">
        <NavLink to="/" className={({ isActive }) => isActive ? 'nav-link active-link' : 'nav-link'}>
          Dashboard
        </NavLink>
        <NavLink to="/authors" className={({ isActive }) => isActive ? 'nav-link active-link' : 'nav-link'}>
          Authors
        </NavLink>
        <NavLink to="/books" className={({ isActive }) => isActive ? 'nav-link active-link' : 'nav-link'}>
          Books
        </NavLink>
        <NavLink to="/users" className={({ isActive }) => isActive ? 'nav-link active-link' : 'nav-link'}>
          Users
        </NavLink>
      </nav>
    </header>
  );
}

export default Navbar;