import React, { useEffect, useState } from 'react';
import api from '../services/api';

function AuthorsPage() {
  const initialForm = {
    name: '',
    email: '',
    specialization: ''
  };

  const [authors, setAuthors] = useState([]);
  const [formData, setFormData] = useState(initialForm);
  const [searchName, setSearchName] = useState('');
  const [editingId, setEditingId] = useState(null);
  const [message, setMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    fetchAuthors();
  }, []);

  const fetchAuthors = async () => {
    try {
      const response = await api.get('/authors');
      setAuthors(response.data);
    } catch (error) {
      setErrorMessage('Failed to load authors list.');
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((previousData) => ({
      ...previousData,
      [name]: value
    }));
  };

  const resetForm = () => {
    setFormData(initialForm);
    setEditingId(null);
    setErrorMessage('');
    setMessage('');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage('');
    setErrorMessage('');

    try {
      if (editingId) {
        await api.put(`/authors/${editingId}`, formData);
        setMessage('Author updated successfully.');
      } else {
        await api.post('/authors', formData);
        setMessage('Author added successfully.');
      }

      resetForm();
      fetchAuthors();
    } catch (error) {
      if (typeof error.response?.data === 'string') {
        setErrorMessage(`Backend says: ${error.response.data}`);
      } else if (error.response?.data?.message) {
        setErrorMessage(`Backend says: ${error.response.data.message}`);
      } else {
        setErrorMessage('Request failed. If Postman works, this page may still be running old code. Save file and restart npm start.');
      }
    }
  };

  const handleEdit = (author) => {
    setFormData({
      name: author.name || '',
      email: author.email || '',
      specialization: author.specialization || ''
    });
    setEditingId(author.authorId);
    setMessage('');
    setErrorMessage('');
  };

  const handleDelete = async (authorId) => {
    const confirmDelete = window.confirm('Are you sure you want to delete this author?');

    if (!confirmDelete) {
      return;
    }

    try {
      await api.delete(`/authors/${authorId}`);
      setMessage('Author deleted successfully.');
      fetchAuthors();

      if (editingId === authorId) {
        resetForm();
      }
    } catch (error) {
      setErrorMessage('Failed to delete author.');
    }
  };

  const handleSearch = async () => {
    setMessage('');
    setErrorMessage('');

    if (searchName.trim() === '') {
      fetchAuthors();
      return;
    }

    try {
      const response = await api.get(`/authors/search?name=${searchName}`);
      setAuthors(response.data);
    } catch (error) {
      setErrorMessage('Failed to search authors.');
    }
  };

  const handleShowAll = () => {
    setSearchName('');
    fetchAuthors();
  };

  return (
    <div className="page-content">
      <section className="content-panel">
        <div className="page-header-row">
          <div>
            <p className="section-tag">Authors</p>
            <h2 className="page-heading">Authors Management</h2>
            <p className="page-description">
              Add, update, delete, and search authors from the Library Management System.
            </p>
          </div>
        </div>
      </section>

      <section className="dashboard-grid-two">
        <div className="form-card">
          <div className="card-header-row">
            <h3>{editingId ? 'Update Author' : 'Add Author'}</h3>
            {editingId && (
              <button type="button" className="secondary-button" onClick={resetForm}>
                Cancel Edit
              </button>
            )}
          </div>

          {message && <div className="success-message">{message}</div>}
          {errorMessage && <div className="error-message">{errorMessage}</div>}

          <div className="debug-box">
            <strong>Frontend payload preview:</strong>
            <pre>{JSON.stringify(formData, null, 2)}</pre>
          </div>

          <form onSubmit={handleSubmit} className="modern-form">
            <div className="form-group">
              <label>Author Name</label>
              <input
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
                placeholder="Enter author name"
                required
              />
            </div>

            <div className="form-group">
              <label>Email</label>
              <input
                type="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                placeholder="Enter email address"
                required
              />
            </div>

            <div className="form-group">
              <label>Specialization</label>
              <textarea
                name="specialization"
                value={formData.specialization}
                onChange={handleChange}
                placeholder="Enter author specialization"
                rows="5"
                required
              ></textarea>
            </div>

            <button type="submit" className="primary-button">
              {editingId ? 'Update Author' : 'Add Author'}
            </button>
          </form>
        </div>

        <div className="table-card">
          <div className="card-header-row">
            <h3>Search Authors</h3>
          </div>

          <div className="search-row">
            <input
              type="text"
              value={searchName}
              onChange={(e) => setSearchName(e.target.value)}
              placeholder="Search by author name"
            />
            <button type="button" className="primary-button small-btn" onClick={handleSearch}>
              Search
            </button>
            <button type="button" className="secondary-button small-btn" onClick={handleShowAll}>
              Show All
            </button>
          </div>

          <div className="table-wrapper">
            <table className="modern-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Specialization</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {authors.length > 0 ? (
                  authors.map((author) => (
                    <tr key={author.authorId}>
                      <td>{author.authorId}</td>
                      <td>{author.name}</td>
                      <td>{author.email}</td>
                      <td>{author.specialization}</td>
                      <td className="action-buttons">
                        <button
                          type="button"
                          className="edit-button"
                          onClick={() => handleEdit(author)}
                        >
                          Edit
                        </button>
                        <button
                          type="button"
                          className="delete-button"
                          onClick={() => handleDelete(author.authorId)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="5" className="no-data-cell">
                      No authors found.
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        </div>
      </section>
    </div>
  );
}

export default AuthorsPage;