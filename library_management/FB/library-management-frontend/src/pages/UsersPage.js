import React, { useEffect, useState } from 'react';
import api from '../services/api';

function UsersPage() {
  const initialForm = {
    fullName: '',
    email: '',
    password: '',
    gender: '',
    interests: [],
    role: '',
    membershipDate: '',
    loginTime: '',
    age: '',
    profileFileName: ''
  };

  const interestOptions = ['Reading', 'Coding', 'Music', 'Travel', 'Sports'];

  const [users, setUsers] = useState([]);
  const [formData, setFormData] = useState(initialForm);
  const [editingId, setEditingId] = useState(null);
  const [message, setMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await api.get('/users');
      setUsers(response.data);
    } catch (error) {
      setErrorMessage('Failed to load user profiles.');
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((previousData) => ({
      ...previousData,
      [name]: value
    }));
  };

  const handleInterestChange = (e) => {
    const { value, checked } = e.target;

    if (checked) {
      setFormData((previousData) => ({
        ...previousData,
        interests: [...previousData.interests, value]
      }));
    } else {
      setFormData((previousData) => ({
        ...previousData,
        interests: previousData.interests.filter((interest) => interest !== value)
      }));
    }
  };

  const resetForm = () => {
    setFormData(initialForm);
    setEditingId(null);
    setMessage('');
    setErrorMessage('');
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];

    setFormData((previousData) => ({
      ...previousData,
      profileFileName: file ? file.name : ''
    }));
  };

  const createPayload = () => {
    return {
      fullName: formData.fullName,
      email: formData.email,
      password: formData.password,
      gender: formData.gender,
      interests: formData.interests,
      role: formData.role,
      membershipDate: formData.membershipDate,
      loginTime: formData.loginTime ? `${formData.loginTime}:00` : '',
      age: Number(formData.age),
      profileFileName: formData.profileFileName
    };
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage('');
    setErrorMessage('');

    try {
      const payload = createPayload();

      if (editingId) {
        await api.put(`/users/${editingId}`, payload);
        setMessage('User profile updated successfully.');
      } else {
        await api.post('/users', payload);
        setMessage('User profile added successfully.');
      }

      resetForm();
      fetchUsers();
    } catch (error) {
      if (typeof error.response?.data === 'string') {
        setErrorMessage(`Backend says: ${error.response.data}`);
      } else if (error.response?.data?.message) {
        setErrorMessage(`Backend says: ${error.response.data.message}`);
      } else {
        setErrorMessage('Failed to save user profile. Check input values and backend validation.');
      }
    }
  };

  const handleEdit = (user) => {
    setFormData({
      fullName: user.fullName || '',
      email: user.email || '',
      password: user.password || '',
      gender: user.gender || '',
      interests: user.interests || [],
      role: user.role || '',
      membershipDate: user.membershipDate || '',
      loginTime: user.loginTime ? user.loginTime.slice(0, 16) : '',
      age: user.age ?? '',
      profileFileName: user.profileFileName || ''
    });

    setEditingId(user.userId);
    setMessage('');
    setErrorMessage('');
  };

  const handleDelete = async (userId) => {
    const confirmDelete = window.confirm('Are you sure you want to delete this user profile?');

    if (!confirmDelete) {
      return;
    }

    try {
      await api.delete(`/users/${userId}`);
      setMessage('User profile deleted successfully.');
      fetchUsers();

      if (editingId === userId) {
        resetForm();
      }
    } catch (error) {
      setErrorMessage('Failed to delete user profile.');
    }
  };

  return (
    <div className="page-content">
      <section className="content-panel">
        <div className="page-header-row">
          <div>
            <p className="section-tag">Users</p>
            <h2 className="page-heading">User Profiles Management</h2>
            <p className="page-description">
              This module demonstrates text, email, password, radio, checkbox, dropdown, date, date-time, number, and file-name handling in one clean form.
            </p>
          </div>
        </div>
      </section>

      <section className="dashboard-grid-two">
        <div className="form-card">
          <div className="card-header-row">
            <h3>{editingId ? 'Update User Profile' : 'Add User Profile'}</h3>
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
              <label>Full Name</label>
              <input
                type="text"
                name="fullName"
                value={formData.fullName}
                onChange={handleChange}
                placeholder="Enter full name"
                required
              />
            </div>

            <div className="form-grid-two">
              <div className="form-group">
                <label>Email</label>
                <input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  placeholder="Enter email"
                  required
                />
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  placeholder="Enter password"
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label>Gender</label>
              <div className="radio-group">
                <label className="radio-option">
                  <input
                    type="radio"
                    name="gender"
                    value="Male"
                    checked={formData.gender === 'Male'}
                    onChange={handleChange}
                  />
                  Male
                </label>

                <label className="radio-option">
                  <input
                    type="radio"
                    name="gender"
                    value="Female"
                    checked={formData.gender === 'Female'}
                    onChange={handleChange}
                  />
                  Female
                </label>

                <label className="radio-option">
                  <input
                    type="radio"
                    name="gender"
                    value="Other"
                    checked={formData.gender === 'Other'}
                    onChange={handleChange}
                  />
                  Other
                </label>
              </div>
            </div>

            <div className="form-group">
              <label>Interests</label>
              <div className="checkbox-group">
                {interestOptions.map((interest) => (
                  <label className="checkbox-option" key={interest}>
                    <input
                      type="checkbox"
                      value={interest}
                      checked={formData.interests.includes(interest)}
                      onChange={handleInterestChange}
                    />
                    {interest}
                  </label>
                ))}
              </div>
            </div>

            <div className="form-grid-two">
              <div className="form-group">
                <label>Role</label>
                <select
                  name="role"
                  value={formData.role}
                  onChange={handleChange}
                  required
                >
                  <option value="">Select role</option>
                  <option value="Student">Student</option>
                  <option value="Admin">Admin</option>
                  <option value="Librarian">Librarian</option>
                  <option value="Guest">Guest</option>
                </select>
              </div>

              <div className="form-group">
                <label>Age</label>
                <input
                  type="number"
                  name="age"
                  value={formData.age}
                  onChange={handleChange}
                  placeholder="Enter age"
                  min="1"
                  required
                />
              </div>
            </div>

            <div className="form-grid-two">
              <div className="form-group">
                <label>Membership Date</label>
                <input
                  type="date"
                  name="membershipDate"
                  value={formData.membershipDate}
                  onChange={handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <label>Login Time</label>
                <input
                  type="datetime-local"
                  name="loginTime"
                  value={formData.loginTime}
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div className="form-group">
              <label>Profile File (optional demo)</label>
              <input
                type="file"
                onChange={handleFileChange}
              />
              {formData.profileFileName && (
                <div className="file-note">
                  Selected file: {formData.profileFileName}
                </div>
              )}
            </div>

            <button type="submit" className="primary-button">
              {editingId ? 'Update User Profile' : 'Add User Profile'}
            </button>
          </form>
        </div>

        <div className="table-card">
          <div className="card-header-row">
            <h3>User Profiles List</h3>
          </div>

          <div className="table-wrapper">
            <table className="modern-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Full Name</th>
                  <th>Email</th>
                  <th>Password</th>
                  <th>Gender</th>
                  <th>Interests</th>
                  <th>Role</th>
                  <th>Membership Date</th>
                  <th>Login Time</th>
                  <th>Age</th>
                  <th>Profile File</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {users.length > 0 ? (
                  users.map((user) => (
                    <tr key={user.userId}>
                      <td>{user.userId}</td>
                      <td>{user.fullName}</td>
                      <td>{user.email}</td>
                      <td>{user.password}</td>
                      <td>{user.gender}</td>
                      <td>{user.interests ? user.interests.join(', ') : ''}</td>
                      <td>{user.role}</td>
                      <td>{user.membershipDate}</td>
                      <td>{user.loginTime}</td>
                      <td>{user.age}</td>
                      <td>{user.profileFileName || 'No file'}</td>
                      <td className="action-buttons">
                        <button
                          type="button"
                          className="edit-button"
                          onClick={() => handleEdit(user)}
                        >
                          Edit
                        </button>
                        <button
                          type="button"
                          className="delete-button"
                          onClick={() => handleDelete(user.userId)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="12" className="no-data-cell">
                      No user profiles found.
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

export default UsersPage;