import { Sidebar } from '../../components';
import { useState } from 'react';

const WarpTracker = () => {
  const [selected, setSelected] = useState('Firefull Flyshine');

  const banners = [
    {
      name: 'Firefull Flyshine',
      image: 'silverwolf-sb(2).png',
    },
    {
      name: 'Nessun Dorma',
      image: 'silverwolf-sb.png',
    },
    {
      name: 'Contract Zero',
      image: 'silverwolf-sb.png',
    },
  ];

  return (
    <div className="flex h-screen">
      <Sidebar banners={banners} selectedBanner={selected} onSelect={setSelected} />
      <main className="flex-1 text-white p-6">
        <h2 className="text-2xl font-bold mb-4">{selected}</h2>
        {/* Main content */}
      </main>
    </div>
  );
};

export default WarpTracker