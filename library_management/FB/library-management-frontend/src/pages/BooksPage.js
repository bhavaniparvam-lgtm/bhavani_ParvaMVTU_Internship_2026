import React, { useEffect, useState } from 'react';
import api from '../services/api';

function BooksPage() {
  const initialForm = {
    title: '',
    genre: '',
    price: '',
    pages: '',
    publishedDate: '',
    available: 'true',
    description: '',
    authorId: ''
  };

  const [books, setBooks] = useState([]);
  const [authors, setAuthors] = useState([]);
  const [formData, setFormData] = useState(initialForm);
  const [editingId, setEditingId] = useState(null);

  const [searchTitle, setSearchTitle] = useState('');
  const [filterGenre, setFilterGenre] = useState('');
  const [filterAvailable, setFilterAvailable] = useState('');

  const [message, setMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    fetchBooks();
    fetchAuthors();
  }, []);

  const fetchBooks = async () => {
    try {
      const response = await api.get('/books');
      setBooks(response.data);
    } catch (error) {
      setErrorMessage('Failed to load books list.');
    }
  };

  const fetchAuthors = async () => {
    try {
      const response = await api.get('/authors');
      setAuthors(response.data);
    } catch (error) {
      setErrorMessage('Failed to load authors for dropdown.');
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
    setMessage('');
    setErrorMessage('');
  };

  const createPayload = () => {
    return {
      title: formData.title,
      genre: formData.genre,
      price: Number(formData.price),
      pages: Number(formData.pages),
      publishedDate: formData.publishedDate,
      available: formData.available === 'true',
      description: formData.description,
      authorId: Number(formData.authorId)
    };
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage('');
    setErrorMessage('');

    try {
      const payload = createPayload();

      if (editingId) {
        await api.put(`/books/${editingId}`, payload);
        setMessage('Book updated successfully.');
      } else {
        await api.post('/books', payload);
        setMessage('Book added successfully.');
      }

      resetForm();
      fetchBooks();
    } catch (error) {
      if (typeof error.response?.data === 'string') {
        setErrorMessage(`Backend says: ${error.response.data}`);
      } else if (error.response?.data?.message) {
        setErrorMessage(`Backend says: ${error.response.data.message}`);
      } else {
        setErrorMessage('Failed to save book. Check backend validation.');
      }
    }
  };

  const handleEdit = (book) => {
    setFormData({
      title: book.title || '',
      genre: book.genre || '',
      price: book.price ?? '',
      pages: book.pages ?? '',
      publishedDate: book.publishedDate || '',
      available: String(book.available),
      description: book.description || '',
      authorId: book.author?.authorId || ''
    });
    setEditingId(book.bookId);
    setMessage('');
    setErrorMessage('');
  };

  const handleDelete = async (bookId) => {
    const confirmDelete = window.confirm('Are you sure you want to delete this book?');

    if (!confirmDelete) {
      return;
    }

    try {
      await api.delete(`/books/${bookId}`);
      setMessage('Book deleted successfully.');
      fetchBooks();

      if (editingId === bookId) {
        resetForm();
      }
    } catch (error) {
      setErrorMessage('Failed to delete book.');
    }
  };

  const handleSearchByTitle = async () => {
    setMessage('');
    setErrorMessage('');

    if (searchTitle.trim() === '') {
      fetchBooks();
      return;
    }

    try {
      const response = await api.get(`/books/search?title=${searchTitle}`);
      setBooks(response.data);
    } catch (error) {
      setErrorMessage('Failed to search books by title.');
    }
  };

  const handleFilterByGenre = async () => {
    setMessage('');
    setErrorMessage('');

    if (filterGenre.trim() === '') {
      fetchBooks();
      return;
    }

    try {
      const response = await api.get(`/books/genre?genre=${filterGenre}`);
      setBooks(response.data);
    } catch (error) {
      setErrorMessage('Failed to filter books by genre.');
    }
  };

  const handleFilterByAvailability = async (value) => {
    setMessage('');
    setErrorMessage('');
    setFilterAvailable(value);

    if (value === '') {
      fetchBooks();
      return;
    }

    try {
      const response = await api.get(`/books/available?available=${value}`);
      setBooks(response.data);
    } catch (error) {
      setErrorMessage('Failed to filter books by availability.');
    }
  };

  const handleShowAll = () => {
    setSearchTitle('');
    setFilterGenre('');
    setFilterAvailable('');
    fetchBooks();
  };

  return (
    <div className="page-content">
      <section className="content-panel">
        <div className="page-header-row">
          <div>
            <p className="section-tag">Books</p>
            <h2 className="page-heading">Books Management</h2>
            <p className="page-description">
              Add, update, delete, and filter books with author mapping in the Library Management System.
            </p>
          </div>
        </div>
      </section>

      <section className="dashboard-grid-two">
        <div className="form-card">
          <div className="card-header-row">
            <h3>{editingId ? 'Update Book' : 'Add Book'}</h3>
            {editingId && (
              <button type="button" className="secondary-button" onClick={resetForm}>
                Cancel Edit
              </button>
            )}
          </div>

          {message && <div className="success-message">{message}</div>}
          {errorMessage && <div className="error-message">{errorMessage}</div>}

          <form onSubmit={handleSubmit} className="modern-form">
            <div className="form-group">
              <label>Book Title</label>
              <input
                type="text"
                name="title"
                value={formData.title}
                onChange={handleChange}
                placeholder="Enter book title"
                required
              />
            </div>

            <div className="form-group">
              <label>Genre</label>
              <input
                type="text"
                name="genre"
                value={formData.genre}
                onChange={handleChange}
                placeholder="Enter genre"
                required
              />
            </div>

            <div className="form-grid-two">
              <div className="form-group">
                <label>Price</label>
                <input
                  type="number"
                  name="price"
                  value={formData.price}
                  onChange={handleChange}
                  placeholder="Enter price"
                  min="0"
                  step="0.01"
                  required
                />
              </div>

              <div className="form-group">
                <label>Pages</label>
                <input
                  type="number"
                  name="pages"
                  value={formData.pages}
                  onChange={handleChange}
                  placeholder="Enter pages"
                  min="1"
                  required
                />
              </div>
            </div>

            <div className="form-grid-two">
              <div className="form-group">
                <label>Published Date</label>
                <input
                  type="date"
                  name="publishedDate"
                  value={formData.publishedDate}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label>Author</label>
                <select
                  name="authorId"
                  value={formData.authorId}
                  onChange={handleChange}
                  required
                >
                  <option value="">Select author</option>
                  {authors.map((author) => (
                    <option key={author.authorId} value={author.authorId}>
                      {author.name}
                    </option>
                  ))}
                </select>
              </div>
            </div>

            <div className="form-group">
              <label>Availability</label>
              <div className="radio-group">
                <label className="radio-option">
                  <input
                    type="radio"
                    name="available"
                    value="true"
                    checked={formData.available === 'true'}
                    onChange={handleChange}
                  />
                  Available
                </label>
                <label className="radio-option">
                  <input
                    type="radio"
                    name="available"
                    value="false"
                    checked={formData.available === 'false'}
                    onChange={handleChange}
                  />
                  Not Available
                </label>
              </div>
            </div>

            <div className="form-group">
              <label>Description</label>
              <textarea
                name="description"
                value={formData.description}
                onChange={handleChange}
                placeholder="Enter book description"
                rows="4"
              ></textarea>
            </div>

            <button type="submit" className="primary-button">
              {editingId ? 'Update Book' : 'Add Book'}
            </button>
          </form>
        </div>

        <div className="table-card">
          <div className="card-header-row">
            <h3>Search and Filter Books</h3>
          </div>

          <div className="filter-stack">
            <div className="search-row">
              <input
                type="text"
                value={searchTitle}
                onChange={(e) => setSearchTitle(e.target.value)}
                placeholder="Search by title"
              />
              <button type="button" className="primary-button small-btn" onClick={handleSearchByTitle}>
                Search
              </button>
            </div>

            <div className="search-row">
              <input
                type="text"
                value={filterGenre}
                onChange={(e) => setFilterGenre(e.target.value)}
                placeholder="Filter by genre"
              />
              <button type="button" className="primary-button small-btn" onClick={handleFilterByGenre}>
                Filter Genre
              </button>
            </div>

            <div className="search-row">
              <select
                value={filterAvailable}
                onChange={(e) => handleFilterByAvailability(e.target.value)}
              >
                <option value="">Filter by availability</option>
                <option value="true">Available</option>
                <option value="false">Not Available</option>
              </select>
              <button type="button" className="secondary-button small-btn" onClick={handleShowAll}>
                Show All
              </button>
            </div>
          </div>

          <div className="table-wrapper">
            <table className="modern-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>Genre</th>
                  <th>Price</th>
                  <th>Pages</th>
                  <th>Published Date</th>
                  <th>Available</th>
                  <th>Description</th>
                  <th>Author</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {books.length > 0 ? (
                  books.map((book) => (
                    <tr key={book.bookId}>
                      <td>{book.bookId}</td>
                      <td>{book.title}</td>
                      <td>{book.genre}</td>
                      <td>{book.price}</td>
                      <td>{book.pages}</td>
                      <td>{book.publishedDate}</td>
                      <td>{book.available ? 'Yes' : 'No'}</td>
                      <td>{book.description}</td>
                      <td>{book.author ? book.author.name : 'No Author'}</td>
                      <td className="action-buttons">
                        <button
                          type="button"
                          className="edit-button"
                          onClick={() => handleEdit(book)}
                        >
                          Edit
                        </button>
                        <button
                          type="button"
                          className="delete-button"
                          onClick={() => handleDelete(book.bookId)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="10" className="no-data-cell">
                      No books found.
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

export default BooksPage;