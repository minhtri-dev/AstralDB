const Sidebar = ({
  banners,
  selectedBanner,
  onSelect,
}: {
  banners: { id: number; name: string; image: string }[];
  selectedBanner: number;
  onSelect: (id: number) => void;
}) => {
  return (
    <aside className="bg-[#23242a] text-white w-110 h-full flex flex-col rounded-lg">
      <h1 className="text-xl font-bold p-3 tracking-wide mb-2">Banners</h1>
      <ul className="space-y-2 px-2" style={{ maxHeight: 'calc(100vh - 5rem)' }}>
        {banners.map((banner) => (
          <li
            key={banner.id}
            className={`bg-[#181B22] flex items-center cursor-pointer transition hover:bg-gray-800 overflow-hidden rounded-lg border border-gray-600 ${
              selectedBanner === banner.id ? 'bg-gray-800 font-semibold' : ''
            }`}
            onClick={() => onSelect(banner.id)}
          >
            <img
              src={banner.image}
              alt={banner.name}
              className="w-50 h-30 object-cover mr-3"
            />
            <span className="ml-auto text-white pr-2">{banner.name}</span>
          </li>
        ))}
      </ul>
    </aside>
  );
};

export default Sidebar;
