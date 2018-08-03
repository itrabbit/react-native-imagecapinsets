import React from 'react';
import PropTypes from 'prop-types';
import {
    View,
    Image,
    requireNativeComponent,
} from 'react-native';

import ImageResizeMode from 'react-native/Libraries/Image/ImageResizeMode';
import resolveAssetSource from 'react-native/Libraries/Image/resolveAssetSource';

const RCTImageCapInset = requireNativeComponent('RCTImageCapInset', {
    propTypes: ImageCapInset.propTypes,
});

class ImageCapInset extends React.Component {
    static propTypes = {
        ...View.propTypes,
        source: Image.propTypes.source,
        capInsets: PropTypes.shape({
            top: PropTypes.number,
            left: PropTypes.number,
            right: PropTypes.number,
            bottom: PropTypes.number,
        }),
    };
    static defaultProps = {
        ...View.defaultProps,
        capInsets: {top: 0, left: 0, right: 0, bottom: 0},
    };

    render() {
        const {children, source, capInsets, ...rest} = this.props;
        const normalizedSource = resolveAssetSource(source);
        // noinspection JSUnresolvedVariable
        return (
            <View {...rest}>
                <RCTImageCapInset
                    capInsets={capInsets}
                    source={normalizedSource}
                    resizeMode={ImageResizeMode.stretch}
                    style={{position: 'absolute', top: 0, left: 0, bottom: 0, right: 0}} />
                {children}
            </View>
        );
    }
}

// noinspection JSUnusedGlobalSymbols
export default ImageCapInset;