import React from 'react';
import SummaryCard from '../components/SummaryCard';

function Dashboard() {
  return (
    <div className="page-content">
      <section className="hero-panel">
        <div>
          <p className="section-tag">Project Dashboard</p>
          <h2 className="page-heading">Library Admin Overview</h2>
          <p className="page-description">
            Manage authors, books, and user profiles through a clean REST API-based full-stack application.
          </p>
        </div>
        <div className="hero-badge">Backend Live on Port 8083</div>
      </section>

      <section className="summary-grid">
        <SummaryCard
          title="Authors Module"
          value="Ready"
          subtitle="Author CRUD and search APIs are working."
          accentClass="accent-teal"
        />
        <SummaryCard
          title="Books Module"
          value="Ready"
          subtitle="Book CRUD, filtering, and author mapping are working."
          accentClass="accent-blue"
        />
        <SummaryCard
          title="Users Module"
          value="Ready"
          subtitle="All input field type handling has been tested."
          accentClass="accent-purple"
        />
      </section>

      <section className="info-panel">
        <div className="info-card">
          <h3>Backend Status</h3>
          <p>Spring Boot REST API is connected to MySQL and tested with Postman.</p>
        </div>
        <div className="info-card">
          <h3>Frontend Goal</h3>
          <p>This interface will now be expanded into a polished college submission-ready full-stack dashboard.</p>
        </div>
      </section>
    </div>
  );
}

export default Dashboard;