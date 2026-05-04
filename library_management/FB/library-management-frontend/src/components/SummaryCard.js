import React from 'react';

function SummaryCard({ title, value, subtitle, accentClass }) {
  return (
    <div className={`summary-card ${accentClass}`}>
      <div className="summary-card-header">
        <span className="summary-card-title">{title}</span>
      </div>
      <h2 className="summary-card-value">{value}</h2>
      <p className="summary-card-subtitle">{subtitle}</p>
    </div>
  );
}

export default SummaryCard;