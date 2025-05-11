import { Link } from 'react-router';
import React, { useState } from 'react';
import { signUp } from 'aws-amplify/auth';

const Register = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);
  const [successMessage, setSuccessMessage] = useState<string | null>(null);

  const handleSignup = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    setSuccessMessage(null);

    try {
      const response = await signUp({
        username,
        password,
        options: {
          userAttributes: {
            email,
          },
        },
      });

      console.log('Signup success:', response);
      setSuccessMessage('Signup successful! Please check your email for the verification code.');
    } catch (err: any) {
      console.error('Signup error:', err);
      setError(err.message || 'Signup failed');
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSignup} style={{ maxWidth: 400, margin: 'auto' }}>
      <h2 className="text-5xl">Sign Up</h2>
      <div>
        <label>Username</label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
      </div>
      <div style={{ marginTop: 8 }}>
        <label>Email</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div style={{ marginTop: 8 }}>
        <label>Password</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      {error && <div style={{ color: 'red', marginTop: 10 }}>{error}</div>}
      {successMessage && <div style={{ color: 'green', marginTop: 10 }}>{successMessage}</div>}
      <button type="submit" disabled={loading} style={{ marginTop: 16 }}>
        {loading ? 'Signing up...' : 'Sign Up'}
      </button>
      <div style={{ marginTop: 16 }}>
        Already have an account? <Link to="/login">Click here</Link>
      </div>
    </form>
  );
};

export default Register;
